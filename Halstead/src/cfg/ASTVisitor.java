package cfg;

import metrics.java7.JavaBaseVisitor;
import metrics.java7.JavaParser;

/**
 * Project: Halstead
 * Package: visitors
 * Author:  Novemser
 * 2016/10/15
 */
public class ASTVisitor extends JavaBaseVisitor {
    private INode currentNode;

    public ASTVisitor(INode node) {
        currentNode = node;
    }

    public ASTVisitor() {

    }


    @Override
    public Object visitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        return super.visitCompilationUnit(ctx);
    }

    @Override
    public Object visitForControl(JavaParser.ForControlContext ctx) {
        System.out.println(ctx.getText());
        return super.visitForControl(ctx);
    }



    @Override
    public Object visitStatementExpression(JavaParser.StatementExpressionContext ctx) {
//        System.out.println(ctx.getText());
        return super.visitStatementExpression(ctx);
    }

    @Override
    public Object visitExpression(JavaParser.ExpressionContext ctx) {
//        System.out.println(ctx.getText());
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitStatement(JavaParser.StatementContext ctx) {
//        System.out.println(ctx.getPayload().getText());
        return super.visitStatement(ctx);
    }
}
