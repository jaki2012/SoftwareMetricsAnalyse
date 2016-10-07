package metrics;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.apache.commons.io.FilenameUtils;

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

    private Tokenizer() {
    }

    public static Tokenizer getInstance() {
        if(instance == null) {
            instance = new Tokenizer();
        }

        return instance;
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
                    Java8Lexer jlexer = new Java8Lexer(stream);
                    CommonTokenStream jtokenStream = new CommonTokenStream(jlexer);
                    Java8Parser jparser = new Java8Parser(jtokenStream);
                    jparser.compilationUnit();
                    token = jparser.getTokenStream();
                }
        }

        for(int var14 = 0; var14 < token.size(); ++var14) {
            this.tokens.add(token.get(var14).getText().toString());
        }

    }
}
