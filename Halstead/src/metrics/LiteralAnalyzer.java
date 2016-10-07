package metrics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class LiteralAnalyzer {
    public LiteralAnalyzer() {
    }

    public void analyzeLiterals() {
        ArrayList cpTokens = Tokenizer.getInstance().tokens;
        Iterator i = cpTokens.iterator();

        while(i.hasNext()) {
            String token = ((String)i.next()).toString();
            if(Operators.getInstance().name.contains(token)) {
                i.remove();
            } else if(Operands.getInstance().name.contains(token)) {
                i.remove();
            } else if(token.equals("<EOF>")) {
                i.remove();
            }
        }

        for(int var4 = 0; var4 < cpTokens.size(); ++var4) {
            Operands.getInstance().insert(((String)cpTokens.get(var4)).toString());
        }

    }
}
