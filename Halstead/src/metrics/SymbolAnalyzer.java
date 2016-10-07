package metrics;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class SymbolAnalyzer {
    String[] symbols = new String[]{"+", "++", "-", "--", "*", ".", ";", "/", "%", "!", ">", "<", ">=", "<=", "==", "=", ":", "~"};

    public SymbolAnalyzer() {
    }

    public int countSymbols(int index) {
        int count = 0;

        for(int i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
            if(((String)Tokenizer.getInstance().tokens.get(i)).toString().equals(this.symbols[index])) {
                ++count;
            }
        }

        return count;
    }

    public void analyzeSymbols() {
        for(int i = 0; i < this.symbols.length; ++i) {
            int count = this.countSymbols(i);
            if(count > 0) {
                Operators.getInstance().insert(this.symbols[i], count);
            }
        }

    }

}
