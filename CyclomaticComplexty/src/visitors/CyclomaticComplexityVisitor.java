package visitors;

import java.util.Stack;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.antlr.v4.runtime.RuleContext;

import grammar.JavaBaseVisitor;
import grammar.JavaParser;
import grammar.JavaParser.ClassDeclarationContext;
import grammar.JavaParser.ConstructorDeclarationContext;
import grammar.JavaParser.EnumDeclarationContext;
import grammar.JavaParser.ExpressionContext;
import grammar.JavaParser.MethodDeclarationContext;
import grammar.JavaParser.StatementContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class CyclomaticComplexityVisitor extends JavaBaseVisitor<Integer> {

	protected Stack<Entry> entryStack = new Stack<Entry>();

	@Override
	public Integer visitStatement(StatementContext ctx) {
		RuleContext rc = ctx.getPayload();

		if (rc != null) {
			//we have a while loop
			if (ctx.getTokens(JavaParser.ELSE).size() > 0 || 
					ctx.getTokens(JavaParser.IF).size() > 0 ||
					ctx.getTokens(JavaParser.WHILE).size() > 0 || 
					ctx.getTokens(JavaParser.FOR).size() > 0 ||
					ctx.getTokens(JavaParser.CATCH).size() > 0 ||
					ctx.getTokens(JavaParser.SWITCH).size() > 0 ||
					ctx.getTokens(JavaParser.DO).size() > 0 ) {

				entryStack.peek().bumpDecisionPoints();
				return super.visitStatement(ctx);
			}
		}

		return super.visitStatement(ctx);
	}

	@Override
	public Integer visitExpression(ExpressionContext ctx) {
		//expression '?' expression ':' expression
		if (ctx.getTokens(JavaParser.QUESTION).size() > 0) {
			entryStack.peek().bumpDecisionPoints();
		}

		return super.visitExpression(ctx);
	}

	public String getParameters(RuleContext context) {
		if(context.getChildCount() == 0) {
			return "";
		} else {
			StringBuilder builder = new StringBuilder();

			for(int i = 0; i < context.getChildCount(); ++i) {
				builder.append(context.getChild(i).getText());
				builder.append(" ");
			}

			return builder.toString();
		}
	}

	@Override
	public Integer visitMethodDeclaration(MethodDeclarationContext ctx) {
		entryStack.push( new Entry( ctx ) );
		Integer res = super.visitMethodDeclaration(ctx);

		Entry methodEntry = entryStack.pop();

		int methodDecisionPoints = methodEntry.decisionPoints;

		System.out.printf("[%-20s method] - CC: %d\n", ctx.Identifier().getText(), methodDecisionPoints);

		Entry classEntry = entryStack.peek();
		classEntry.methodCount++;
		classEntry.bumpDecisionPoints( methodDecisionPoints );

		if ( methodDecisionPoints > classEntry.highestDecisionPoints ) {
			classEntry.highestDecisionPoints = methodDecisionPoints;
		}

		return res;
	}

	@Override
	public Integer visitClassDeclaration(ClassDeclarationContext ctx) {
		entryStack.push( new Entry( ctx) );
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
		entryStack.push( new Entry( ctx ) );
		Integer res = super.visitConstructorDeclaration(ctx);
		Entry constructorEntry = entryStack.pop();

		int constructorDecisionPointCount = constructorEntry.decisionPoints;
		Entry classEntry = entryStack.peek();
		classEntry.methodCount++;
		classEntry.decisionPoints += constructorDecisionPointCount;

		if ( constructorDecisionPointCount > classEntry.highestDecisionPoints ) {
			classEntry.highestDecisionPoints = constructorDecisionPointCount;
		}

		return res;
	}

	@Override
	public Integer visitEnumDeclaration(EnumDeclarationContext ctx) {
		entryStack.push( new Entry( ctx ) );
		Integer res = super.visitEnumDeclaration(ctx);
		Entry classEntry = entryStack.pop();

		return res;
	}
}


class Entry {
	private Object node;
	public int decisionPoints = 1;
	public int highestDecisionPoints;
	public int methodCount;

	Entry(Object node) {
		this.node = node;
	}

	public void bumpDecisionPoints() {
		decisionPoints++;
	}

	public void bumpDecisionPoints(int size) {
		decisionPoints += size;
	}

	public int getComplexityAverage() {
		return (double) methodCount == 0 ? 1
				: (int) Math.rint( (double) decisionPoints / (double) methodCount );
	}
}
