package simple;
// Generated from Exp.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExpParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExpParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(ExpParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(ExpParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ExpParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ExpParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ExpParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ExpParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ExpParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExpParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExpParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExpParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExpParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ExpParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ExpParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ExpParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ExpParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ExpParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ExpParser.IntContext ctx);
}