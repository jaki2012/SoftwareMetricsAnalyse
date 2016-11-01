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

        while (i.hasNext()) {
            String token = ((String) i.next());
            if (Operators.getInstance().name.contains(token)) {
                i.remove();
            } else if (Operands.getInstance().name.contains(token)) {
                i.remove();
            } else if (token.equals("<EOF>")) {
                i.remove();
            }
        }

        for (int j = 0; j < cpTokens.size(); ++j) {
            Operands.getInstance().insert(cpTokens.get(j).toString());
        }

    }
}
