package visitors;

import metrics.MetricsEvaluator;
import metrics.java7.JavaBaseVisitor;
import metrics.java7.JavaParser;
import metrics.java7.JavaParser.*;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CyclomaticComplexityVisitor extends JavaBaseVisitor<Integer> {

    protected Stack<Entry> entryStack = new Stack<Entry>();
    private MetricsEvaluator me;
    private Set<String> decisionPointSet = new HashSet<>();

    public CyclomaticComplexityVisitor(MetricsEvaluator evaluator) {
        me = evaluator;
        decisionPointSet.add("return");
        decisionPointSet.add("if");
        decisionPointSet.add("else");
        decisionPointSet.add("case");
        decisionPointSet.add("default");
        decisionPointSet.add("for");
        decisionPointSet.add("while");
        decisionPointSet.add("do");
//        decisionPointSet.add("break");
        decisionPointSet.add("continue");
        decisionPointSet.add("&&");
        decisionPointSet.add("||");
        decisionPointSet.add("?");
        decisionPointSet.add("catch");
        decisionPointSet.add("finally");
        decisionPointSet.add("throw");
    }

    private void addPeekDecitionPoint() {
        entryStack.peek().bumpDecisionPoints();
    }

    private void addPeekNodeCount() {
        entryStack.peek().addNode();
    }

    private void addPeekNodeCount(int num) {
        entryStack.peek().addNodes(num);
    }

    private int getSmtCnt(String text, String smt) {
        int smtLength = text.length() - text.replace(smt, "").length();
        return smtLength / smt.length();
    }

    @Override
    public Integer visitCatchClause(CatchClauseContext ctx) {
        addPeekDecitionPoint();
        addPeekNodeCount();
        return super.visitCatchClause(ctx);
    }

    @Override
    public Integer visitFinallyBlock(FinallyBlockContext ctx) {
        addPeekDecitionPoint();
        addPeekNodeCount();
        return super.visitFinallyBlock(ctx);
    }

    @Override
    public Integer visitStatement(StatementContext ctx) {
        RuleContext rc = ctx.getPayload();

        if (rc != null) {
            if (ctx.getTokens(JavaParser.RETURN).size() > 0) {
                addPeekNodeCount();
            }
            if (ctx.getTokens(JavaParser.TRY).size() > 0) {
                addPeekNodeCount();
                handleEmptyContext(1, rc);
            }

            if (ctx.getTokens(JavaParser.CATCH).size() > 0 ||
                    ctx.getTokens(JavaParser.DO).size() > 0 ||
                    ctx.getTokens(JavaParser.CONTINUE).size() > 0) {

                addPeekDecitionPoint();
                addPeekNodeCount();
                return super.visitStatement(ctx);
            } else if(ctx.getTokens(JavaParser.IF).size() > 0 ) {
                addPeekDecitionPoint();
                addPeekNodeCount();
                handleEmptyContext(2, rc);
            } else if (ctx.getTokens(JavaParser.WHILE).size() > 0) {
                addPeekDecitionPoint();
                addPeekNodeCount();
                handleEmptyContext(2, rc);
            } else if (ctx.getTokens(JavaParser.CATCH).size() > 0) {
                addPeekDecitionPoint();
                addPeekNodeCount();

            }

            else if (ctx.getTokens(JavaParser.SWITCH).size() > 0) {
                addPeekNodeCount();

                for (int i = rc.getChildCount() - 1; i >= 0; i--) {
                    String child = rc.getChild(i).getText();
                    if (!child.contains("switch")) {
                        addPeekNodeCount(getSmtCnt(child, "case"));
                        addPeekNodeCount(getSmtCnt(child, "default"));
                    } else {
                        int index = child.indexOf("switch");
                        if (index > 0)  {
                            String preSwitch = child.substring(0, index);
                            addPeekNodeCount(getSmtCnt(preSwitch, "case"));
                            addPeekNodeCount(getSmtCnt(preSwitch, "default"));
                        }
                    }

                    if (child.contains("break;")) {
                        // while connected case statements count as a single decision
                        if (child.contains("case")) {
                            addPeekDecitionPoint();
                        }
                    }
                }
            } else if (ctx.getTokens(JavaParser.FOR).size() > 0) {
                addPeekNodeCount();
                handleEmptyContext(4, rc);
                Pattern p = Pattern.compile(";(.*?);");
                Matcher m = p.matcher(rc.getText());
                if (m.find()) {
                    if (!m.group(1).equals("")) {
                        addPeekDecitionPoint();
                    }
                }
            }
        }

        return super.visitStatement(ctx);
    }

    private void handleEmptyContext(int startChild, RuleContext rc) {
        int n = rc.getChildCount();
        for (int i = startChild; i < n; i ++) {
            ParseTree child = rc.getChild(i);
            boolean flag = false;
            for (String keyWord : decisionPointSet) {
                if (child.getText().contains(keyWord)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                addPeekNodeCount();
            }
        }
    }

    @Override
    public Integer visitCompilationUnit(CompilationUnitContext ctx) {
        return super.visitCompilationUnit(ctx);
    }

    @Override
    public Integer visitExpression(ExpressionContext ctx) {
        //expression '?' expression ':' expression
        if (ctx.getTokens(JavaParser.QUESTION).size() > 0 ||
                ctx.getTokens(JavaParser.OR).size() > 0 ||
                ctx.getTokens(JavaParser.AND).size() > 0) {
//            System.out.println(ctx.getText());
            addPeekDecitionPoint();
            addPeekNodeCount();
        }

        return super.visitExpression(ctx);
    }

    public String getParameters(RuleContext context) {
        if (context.getChildCount() == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < context.getChildCount(); ++i) {
                builder.append(context.getChild(i).getText());
                builder.append(" ");
            }

            return builder.toString();
        }
    }

    @Override
    public Integer visitMethodDeclaration(MethodDeclarationContext ctx) {
        entryStack.push(new Entry());
        entryStack.peek().setVoid(ctx.getText().toLowerCase().startsWith("void"));
        Integer res = super.visitMethodDeclaration(ctx);

        System.out.println(ctx.getText());
        Entry methodEntry = entryStack.pop();

        int methodDecisionPoints = methodEntry.decisionPoints;

        System.out.printf("[%-20s methodName] - CC: %d\t\tNodes: %d\n", ctx.Identifier().getText(), methodDecisionPoints, methodEntry.getNodeCnt());

        Entry classEntry = entryStack.peek();
        classEntry.methodCount++;
        classEntry.bumpDecisionPoints(methodDecisionPoints);

        if (methodDecisionPoints > classEntry.highestDecisionPoints) {
            classEntry.highestDecisionPoints = methodDecisionPoints;
        }

        return res;
    }

    @Override
    public Integer visitClassDeclaration(ClassDeclarationContext ctx) {
        entryStack.push(new Entry());
        Integer res = super.visitClassDeclaration(ctx);

        Entry classEntry = entryStack.peek();
        double avgCC = classEntry.methodCount != 0 ? classEntry.decisionPoints * 1f / classEntry.methodCount : 0;
        System.out.println("Summary:");
        System.out.printf("Overall methods count: %d\n", classEntry.methodCount);
        System.out.printf("[%-20s class] - avg CC: %.2f\n", ctx.Identifier().getText(), avgCC);

        System.out.println(new String(new char[30]).replace("\0", "="));
        return res;
    }

    @Override
    public Integer visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
        entryStack.push(new Entry());
        Integer res = super.visitConstructorDeclaration(ctx);
        Entry constructorEntry = entryStack.pop();

        int constructorDecisionPointCount = constructorEntry.decisionPoints;
        Entry classEntry = entryStack.peek();
        classEntry.methodCount++;
        classEntry.decisionPoints += constructorDecisionPointCount;

        if (constructorDecisionPointCount > classEntry.highestDecisionPoints) {
            classEntry.highestDecisionPoints = constructorDecisionPointCount;
        }

        return res;
    }

    @Override
    public Integer visitEnumDeclaration(EnumDeclarationContext ctx) {
        entryStack.push(new Entry());
        Integer res = super.visitEnumDeclaration(ctx);
        Entry classEntry = entryStack.pop();

        return res;
    }
}


class Entry {
    private int nodeCnt = 1;
    public int decisionPoints = 1;
    public int highestDecisionPoints;
    public int methodCount;
    private boolean isVoidMethod;


    public void bumpDecisionPoints() {
        decisionPoints++;
    }

    public void bumpDecisionPoints(int size) {
        decisionPoints += size;
    }

    public void addNode() {
        nodeCnt++;
    }

    public int getNodeCnt() {
        return nodeCnt;
    }

    public void addNodes(int num) {
        if (num > 0)
            nodeCnt += num;
    }

    public int getComplexityAverage() {
        return (double) methodCount == 0 ? 1
                : (int) Math.rint((double) decisionPoints / (double) methodCount);
    }

    public boolean isVoidMethod() {
        return isVoidMethod;
    }

    public void setVoid(boolean isVoid) {
        isVoidMethod = isVoid;
    }
}
