package visitors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.body.VariableDeclaratorId;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.ModifierVisitorAdapter;

/**
 * Created by Novemser on 2016/10/6.
 */
public class MyVisitor extends ModifierVisitorAdapter {

    @Override
    public Node visit (ExpressionStmt stmt, Object args)
    {
        super.visit(stmt,args);
        if (stmt.getExpression()==null)
        {
            return null;
        }
        return stmt;
    }

    @Override
    public Node visit (VariableDeclarationExpr declarationExpr, Object args)
    {
        super.visit(declarationExpr, args);
//        System.out.println(declarationExpr);

        if (declarationExpr.getVars().isEmpty()) {
            return null;
        }

        return declarationExpr;
    }

    @Override
    public Node visit(AssignExpr n, Object arg) {
        return super.visit(n, arg);
    }

    @Override
    public Node visit(VariableDeclarator n, Object arg) {
        return super.visit(n, arg);
    }

    @Override
    public Node visit(VariableDeclaratorId n, Object arg) {
        return super.visit(n, arg);
    }

    @Override
    public Node visit(MethodReferenceExpr n, Object arg) {
        return super.visit(n, arg);
    }

    @Override
    public Node visit(BlockComment n, Object arg) {
        return super.visit(n, arg);
    }

    @Override
    public Node visit(LineComment n, Object arg) {
        return super.visit(n, arg);
    }
}
