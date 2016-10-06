import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.TypeParameter;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashMap;

/**
 * Created by Novemser on 2016/10/6.
 */
public class CalculateVisitor extends VoidVisitorAdapter {
    public static HashMap<String, Integer> operators;
    public static HashMap<String, Integer> operands;

    static {
        operands = new HashMap<>();
        operators = new HashMap<>();
    }

    private void addOperator(String aDefault) {
        if (operators.containsKey(aDefault))
            operators.put(aDefault, operators.get(aDefault) + 1);
        else
            operators.put(aDefault, 1);
    }

    private void addOperand(String op) {
        if (operands.containsKey(op))
            operands.put(op, operands.get(op) + 1);
        else
            operands.put(op, 1);
    }

    @Override
    public void visit(AnnotationDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(AnnotationMemberDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ArrayAccessExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ArrayCreationExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ArrayInitializerExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(AssertStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(AssignExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(BinaryExpr n, Object arg) {

        super.visit(n, arg);
    }

    @Override
    public void visit(BlockComment n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(BlockStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(BooleanLiteralExpr n, Object arg) {
        addOperator(n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(BreakStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(CastExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(CatchClause n, Object arg) {
        addOperator("catch");
        super.visit(n, arg);
    }

    @Override
    public void visit(CharLiteralExpr n, Object arg) {
        addOperand(n.getValue());
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceType n, Object arg) {
        String op = n.getName();
        addOperand(op);
        super.visit(n, arg);
    }

    @Override
    public void visit(CompilationUnit n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ConditionalExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ConstructorDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ContinueStmt n, Object arg) {
        addOperator("continue");
        super.visit(n, arg);
    }

    @Override
    public void visit(DoStmt n, Object arg) {
        super.visit(n, arg);

        addOperator("do");
    }

    @Override
    public void visit(DoubleLiteralExpr n, Object arg) {
        addOperand(n.getValue());
        super.visit(n, arg);
    }

    @Override
    public void visit(EmptyMemberDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(EmptyStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(EmptyTypeDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(EnclosedExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(EnumConstantDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(EnumDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ExplicitConstructorInvocationStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ExpressionStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldAccessExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ForeachStmt n, Object arg) {
        super.visit(n, arg);

        addOperator("foreach");
    }

    @Override
    public void visit(ForStmt n, Object arg) {
        addOperator("for");
        super.visit(n, arg);
    }

    @Override
    public void visit(IfStmt n, Object arg) {
        addOperator("if");
        if (n.getElseStmt() != null)
            addOperator("else");
        super.visit(n, arg);
    }

    @Override
    public void visit(ImportDeclaration n, Object arg) {
        String op = n.getName().toString();
        addOperator(op);
        super.visit(n, arg);
    }

    @Override
    public void visit(InitializerDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(InstanceOfExpr n, Object arg) {
        addOperator("instanceof");
        super.visit(n, arg);
    }

    @Override
    public void visit(IntegerLiteralExpr n, Object arg) {
        addOperand(n.getValue());
        super.visit(n, arg);
    }

    @Override
    public void visit(IntegerLiteralMinValueExpr n, Object arg) {
        addOperand(n.getValue());
        super.visit(n, arg);
    }

    @Override
    public void visit(JavadocComment n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(LabeledStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(LineComment n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(LongLiteralExpr n, Object arg) {
        addOperand(n.getValue());

        super.visit(n, arg);
    }

    @Override
    public void visit(LongLiteralMinValueExpr n, Object arg) {
        addOperand(n.getValue());
        super.visit(n, arg);
    }

    @Override
    public void visit(MarkerAnnotationExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MemberValuePair n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodCallExpr n, Object arg) {
        addOperator(n.getName());
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        String method = n.getDeclarationAsString();

        if (method.contains("static"))
            addOperator("static");
        if (method.contains("public"))
            addOperator("public");
        if (method.contains("private"))
            addOperator("private");
        if (method.contains("protected"))
            addOperator("protected");
        if (method.contains("abstract"))
            addOperator("abstract");

        super.visit(n, arg);
    }

    @Override
    public void visit(NameExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(NormalAnnotationExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(NullLiteralExpr n, Object arg) {
        addOperand(n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(ObjectCreationExpr n, Object arg) {
        addOperator("new");
        super.visit(n, arg);
    }

    @Override
    public void visit(PackageDeclaration n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(Parameter n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MultiTypeParameter n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(PrimitiveType n, Object arg) {
        String op = n.getType().toString();
        addOperand(op);

        super.visit(n, arg);
    }


    @Override
    public void visit(QualifiedNameExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ReferenceType n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(IntersectionType n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(UnionType n, Object arg) {
        addOperator("union");

        super.visit(n, arg);
    }

    @Override
    public void visit(ReturnStmt n, Object arg) {
        addOperator("return");

        super.visit(n, arg);
    }

    @Override
    public void visit(SingleMemberAnnotationExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(StringLiteralExpr n, Object arg) {
        String op = n.toString();
        addOperand(op);
        super.visit(n, arg);
    }

    @Override
    public void visit(SuperExpr n, Object arg) {
        addOperator("super");

        super.visit(n, arg);
    }

    @Override
    public void visit(SwitchEntryStmt n, Object arg) {
        Expression expression = n.getLabel();
        if (expression != null) {
            addOperator("case");
        }
        else
            addOperator("default");

        super.visit(n, arg);
    }

    @Override
    public void visit(SwitchStmt n, Object arg) {
        addOperator("switch");

        super.visit(n, arg);
    }

    @Override
    public void visit(SynchronizedStmt n, Object arg) {
        addOperator("synchronized");
        super.visit(n, arg);
    }

    @Override
    public void visit(ThisExpr n, Object arg) {
        addOperator("this");
        super.visit(n, arg);
    }

    @Override
    public void visit(ThrowStmt n, Object arg) {
        addOperator("throw");
        super.visit(n, arg);
    }

    @Override
    public void visit(TryStmt n, Object arg) {
        addOperator("try");
        super.visit(n, arg);
    }

    @Override
    public void visit(TypeDeclarationStmt n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(TypeParameter n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(UnaryExpr n, Object arg) {
        String op = n.getOperator().toString();
        addOperator(op);
        super.visit(n, arg);
    }

    @Override
    public void visit(UnknownType n, Object arg) {

        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclarator n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclaratorId n, Object arg) {
        addOperand(n.getName());
        super.visit(n, arg);
    }

    @Override
    public void visit(VoidType n, Object arg) {
        addOperator("void");
        super.visit(n, arg);
    }

    @Override
    public void visit(WhileStmt n, Object arg) {
        super.visit(n, arg);

        addOperator("while");
    }

    @Override
    public void visit(WildcardType n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(LambdaExpr n, Object arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodReferenceExpr n, Object arg) {
        System.out.println(n);
        super.visit(n, arg);
    }

    @Override
    public void visit(TypeExpr n, Object arg) {
        super.visit(n, arg);
    }
}
