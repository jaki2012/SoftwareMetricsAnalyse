package simple;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Project: Halstead
 * Package: simple
 * Author:  Novemser
 * 2016/10/11
 */
public class Calc {
    public static void main(String...args) throws Exception {
        InputStream inputStream =
                new FileInputStream("E:\\MyCodes\\Lab409\\SoftwareMetricsAnalyse\\Halstead\\src\\simple\\SimpleExpr");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        ExpLexer lexer = new ExpLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokenStream);

        ParseTree tree = parser.prog();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
