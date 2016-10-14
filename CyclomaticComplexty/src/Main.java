import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;

import grammar.JavaLexer;
import grammar.JavaParser;
import visitors.CyclomaticComplexityVisitor;

public class Main {
	public static void main(String[] args) throws IOException {
		String f =
				"E:\\MyCodes\\Java\\FileSys\\src\\simple.java";

		Lexer lexer = new JavaLexer(new ANTLRFileStream(f));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParserRuleContext tree = parser.compilationUnit();
		
		CyclomaticComplexityVisitor mv = new CyclomaticComplexityVisitor();
		mv.visit(tree);
	}
}
