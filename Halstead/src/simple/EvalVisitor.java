package simple;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ExpBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<String, Double>();

    @Override
    public Double visitProg(ExpParser.ProgContext ctx) {
        System.out.println("Visit prog");
        return super.visitProg(ctx);
    }

    @Override
    public Double visitPrintExpr(ExpParser.PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        System.out.println(value);
        return 0.;
    }

    @Override
    public Double visitAssign(ExpParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Double visitBlank(ExpParser.BlankContext ctx) {
        return super.visitBlank(ctx);
    }

    @Override
    public Double visitParens(ExpParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitMulDiv(ExpParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == ExpParser.MUL ) return left * right;
        return left / right;
    }

    @Override
    public Double visitAddSub(ExpParser.AddSubContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == ExpParser.ADD ) return left + right;
        return left - right;
    }

    @Override
    public Double visitId(ExpParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return 0.;
    }

    @Override
    public Double visitInt(ExpParser.IntContext ctx) {
        return Double.valueOf(ctx.INT().getText());
    }
}
