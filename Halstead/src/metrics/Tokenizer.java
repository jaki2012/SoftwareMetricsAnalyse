package metrics;

import metrics.c.CLexer;
import metrics.c.CParser;
import metrics.cpp.CPP14Lexer;
import metrics.cpp.CPP14Parser;
import metrics.java7.JavaLexer;
import metrics.java7.JavaParser;
import org.antlr.v4.runtime.*;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class Tokenizer {
    public ArrayList<String> tokens = new ArrayList();
    protected static Tokenizer instance;
    public static String fileType = null;
//    public static ParserRuleContext tree;

    private Tokenizer() {
    }

    public static Tokenizer getInstance() {
        if(null == instance) {
            instance = new Tokenizer();
        }

        return instance;
    }

    public static void reset() {
        if (null != instance)
            instance.tokens.clear();
    }

    public void tokenize(CharStream stream) {
        TokenStream token = null;
        fileType = "java";
        // Using java7 parser is faster
        JavaLexer lexer = new JavaLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokenStream);
        parser.compilationUnit();
        token = parser.getTokenStream();

        for(int i = 0; i < token.size(); ++i) {
            this.tokens.add(token.get(i).getText());
        }
    }

    public void tokenize(String fileURL) throws IOException {
        TokenStream token = null;
        ANTLRFileStream stream = new ANTLRFileStream(fileURL);
        fileType = FilenameUtils.getExtension(fileURL);
        String var4;
        switch((var4 = fileType.toLowerCase()).hashCode()) {
            case 99:
                if(var4.equals("c")) {
                    CLexer i = new CLexer(stream);
                    CommonTokenStream ctokenStream = new CommonTokenStream(i);
                    CParser cparser = new CParser(ctokenStream);
                    cparser.compilationUnit();
                    token = cparser.getTokenStream();
                }
                break;
            case 98723:
                if(var4.equals("cpp")) {
                    CPP14Lexer cpplexer = new CPP14Lexer(stream);
                    CommonTokenStream cpptokenStream = new CommonTokenStream(cpplexer);
                    CPP14Parser cppparser = new CPP14Parser(cpptokenStream);
                    cppparser.translationunit();
                    token = cppparser.getTokenStream();
                }
                break;
            case 3254818:
                if(var4.equals("java")) {
                    // Using java7 parser is faster
                    JavaLexer lexer = new JavaLexer(stream);
                    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                    JavaParser parser = new JavaParser(tokenStream);
//                    Tokenizer.tree = parser.compilationUnit();
                    token = parser.getTokenStream();

                    // Using java8 parser is too slow in general
//                    Java8Lexer jlexer = new Java8Lexer(stream);
//                    CommonTokenStream jtokenStream = new CommonTokenStream(jlexer);
//                    Java8Parser jparser = new Java8Parser(jtokenStream);
//                    jparser.compilationUnit();
//                    token = jparser.getTokenStream();
                }
        }

        for(int var14 = 0; var14 < token.size(); ++var14) {
            this.tokens.add(token.get(var14).getText());
        }

    }

    public static char[] ReadFileToCharArray(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            System.out.println(numRead);
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }

        reader.close();

        return  fileData.toString().toCharArray();
    }
}
