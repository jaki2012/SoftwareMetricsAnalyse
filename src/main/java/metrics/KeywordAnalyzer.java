package metrics;

import metrics.c.CKeywords;
import metrics.cpp.CPP14Keywords;
import metrics.java.Java8Keywords;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class KeywordAnalyzer {
    public KeywordAnalyzer() {
    }

    public void analyzeKeywords() {
        int i;
        String fileType = Tokenizer.fileType.toLowerCase();

        if (fileType.equals("c")) {
            for (i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                if (CKeywords.isKeyword(Tokenizer.getInstance().tokens.get(i))) {
                    Operators.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                } else if (Tokenizer.getInstance().tokens.get(i).charAt(0) == '\"') {
                    Operands.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                }
            }
        }
        if (fileType.equals("cpp")) {
            for (i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                if (CPP14Keywords.isKeyword(Tokenizer.getInstance().tokens.get(i))) {
                    Operators.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                } else if (Tokenizer.getInstance().tokens.get(i).charAt(0) == '\"') {
                    Operands.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                }
            }
        }
        if (fileType.equals("java")) {
            for (i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                if (Java8Keywords.isKeyword(Tokenizer.getInstance().tokens.get(i))) {
                    Operators.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                } else if (Tokenizer.getInstance().tokens.get(i).charAt(0) == '\"') {
                    Operands.getInstance().insert(Tokenizer.getInstance().tokens.get(i));
                }
            }
        }

    }
}
