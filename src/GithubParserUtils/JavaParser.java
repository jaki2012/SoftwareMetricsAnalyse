//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package GithubParserUtils;

import GithubParserUtils.CommentsInserter;
import com.github.javaparser.InstanceJavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.SourcesHelper;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class JavaParser {
    private static final CommentsInserter commentsInserter = new CommentsInserter();
    public static int LOC_CODE_AND_COMMENT = 0;
    public static ArrayList<Comment> commentNode = new ArrayList<Comment>();

    private JavaParser() {
    }

    public static boolean getDoNotConsiderAnnotationsAsNodeStartForCodeAttribution() {
        return commentsInserter.getDoNotConsiderAnnotationsAsNodeStartForCodeAttribution();
    }

    public static void setDoNotConsiderAnnotationsAsNodeStartForCodeAttribution(boolean newValue) {
        commentsInserter.setDoNotConsiderAnnotationsAsNodeStartForCodeAttribution(newValue);
    }

    public static boolean getDoNotAssignCommentsPreceedingEmptyLines() {
        return commentsInserter.getDoNotAssignCommentsPreceedingEmptyLines();
    }

    public static void setDoNotAssignCommentsPreceedingEmptyLines(boolean newValue) {
        commentsInserter.setDoNotAssignCommentsPreceedingEmptyLines(newValue);
    }

    public static CompilationUnit parse(InputStream in, String encoding) throws ParseException {
        return parse(in, encoding, true);
    }

    public static CompilationUnit parse(InputStream in, String encoding, boolean considerComments) throws ParseException {
        try {
            InputStreamReader ioe = new InputStreamReader(in, encoding);

            CompilationUnit var4;
            try {
                var4 = parse(ioe, considerComments);
            } finally {
                ioe.close();
            }

            return var4;
        } catch (IOException var9) {
            throw new ParseException(var9.getMessage());
        }
    }

    public static CompilationUnit parse(InputStream in) throws ParseException {
        return parse(in, Charset.defaultCharset().name(), true);
    }

    public static CompilationUnit parse(File file, String encoding) throws ParseException, IOException {
        return parse(file, encoding, true);
    }

    public static CompilationUnit parse(File file, String encoding, boolean considerComments) throws ParseException {
        try {
            FileInputStream ioe = new FileInputStream(file);

            CompilationUnit var4;
            try {
                var4 = parse((InputStream)ioe, encoding, considerComments);
            } finally {
                ioe.close();
            }

            return var4;
        } catch (IOException var9) {
            throw new ParseException(var9.getMessage());
        }
    }

    public static CompilationUnit parse(File file) throws ParseException, IOException {
        return parse(file, Charset.defaultCharset().name(), true);
    }

    public static CompilationUnit parse(Reader reader) throws ParseException {
        return parse(reader, true);
    }

    public static CompilationUnit parse(Reader reader, boolean considerComments) throws ParseException {
        try {
            String ioe = SourcesHelper.readerToString(reader);
            CompilationUnit cu = (new InstanceJavaParser(ioe)).parse();
            if(considerComments) {
                commentsInserter.insertComments(cu, ioe);
                LOC_CODE_AND_COMMENT = commentsInserter.LOC_CODE_AND_COMMENT;
                commentNode = commentsInserter.commentNode;
            }

            return cu;
        } catch (IOException var4) {
            throw new ParseException(var4.getMessage());
        }
    }

    public static BlockStmt parseBlock(String blockStatement) throws ParseException {
        return (new InstanceJavaParser(blockStatement)).parseBlock();
    }

    public static Statement parseStatement(String statement) throws ParseException {
        return (new InstanceJavaParser(statement)).parseStatement();
    }

    public static List<Statement> parseStatements(String statements) throws ParseException {
        return (new InstanceJavaParser(statements)).parseStatements();
    }

    public static ImportDeclaration parseImport(String importDeclaration) throws ParseException {
        return (new InstanceJavaParser(importDeclaration)).parseImport();
    }

    public static Expression parseExpression(String expression) throws ParseException {
        return (new InstanceJavaParser(expression)).parseExpression();
    }

    public static AnnotationExpr parseAnnotation(String annotation) throws ParseException {
        return (new InstanceJavaParser(annotation)).parseAnnotation();
    }

    public static BodyDeclaration parseBodyDeclaration(String body) throws ParseException {
        return (new InstanceJavaParser(body)).parseBodyDeclaration();
    }

    public static BodyDeclaration parseClassBodyDeclaration(String body) throws ParseException {
        return (new InstanceJavaParser(body)).parseClassBodyDeclaration();
    }

    public static BodyDeclaration parseInterfaceBodyDeclaration(String body) throws ParseException {
        return (new InstanceJavaParser(body)).parseInterfaceBodyDeclaration();
    }
}
