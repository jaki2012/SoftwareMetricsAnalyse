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
        String var1;
        int i;
        switch((var1 = Tokenizer.fileType.toLowerCase()).hashCode()) {
            case 99:
                if(var1.equals("c")) {
                    for(i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                        if(CKeywords.isKeyword(((String)Tokenizer.getInstance().tokens.get(i)).toString())) {
                            Operators.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        } else if(((String)Tokenizer.getInstance().tokens.get(i)).toString().charAt(0) == 34) {
                            Operands.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        }
                    }
                }
                break;
            case 98723:
                if(var1.equals("cpp")) {
                    for(i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                        if(CPP14Keywords.isKeyword(((String)Tokenizer.getInstance().tokens.get(i)).toString())) {
                            Operators.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        } else if(((String)Tokenizer.getInstance().tokens.get(i)).toString().charAt(0) == 34) {
                            Operands.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        }
                    }
                }
                break;
            case 3254818:
                if(var1.equals("java")) {
                    for(i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
                        if(Java8Keywords.isKeyword(((String)Tokenizer.getInstance().tokens.get(i)).toString())) {
                            Operators.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        } else if(((String)Tokenizer.getInstance().tokens.get(i)).toString().charAt(0) == 34) {
                            Operands.getInstance().insert(((String)Tokenizer.getInstance().tokens.get(i)).toString());
                        }
                    }
                }
        }

    }
}
