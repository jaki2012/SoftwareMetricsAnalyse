package cfg;

import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import metrics.java7.JavaParser;

/**
 * Project: Halstead
 * Package: cfg
 * Author:  Novemser
 * 2016/10/15
 */
public class JavaASTVisitor extends VoidVisitorAdapter {
    private INode current;

    public JavaASTVisitor(INode node) {
        current = node;
    }

    public JavaASTVisitor() {

    }

    @Override
    public void visit(ExpressionStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ForStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(WhileStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(DoStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(SwitchStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(BreakStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ContinueStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ReturnStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ThrowStmt n, Object arg) {
        super.visit(n, arg);
    }


    @Override
    public void visit(IfStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(TryStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        INode expNode = new FNode(n.toString(), JavaParser.RULE_statementExpression);
        expNode.setInfo(n.toString());
        super.visit(n, arg);
    }

    private void addToCursor(INode current, INode ast) {
        if (current.getNodes().size() > 1) {
            if (current.getNodes().get(1).getType() == 0) {

            }
        }
    }
}
