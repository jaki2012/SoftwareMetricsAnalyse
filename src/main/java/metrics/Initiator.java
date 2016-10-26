package metrics;

import org.antlr.v4.runtime.CharStream;
import visitors.CalculateVisitor;

/**
 * Project: Halstead
 * Package: PACKAGE_NAME
 * Author:  Novemser
 * 2016/10/7
 */
public class Initiator {
    public Initiator() {
    }

    public MetricsEvaluator initiate(CharStream stream) throws Exception {
        resetOps();
        Tokenizer.getInstance().tokenize(stream);

        return getEvaluator();
    }

    private void resetOps() {
        Tokenizer.reset();
        Operators.getInstance().count.clear();
        Operators.getInstance().name.clear();
        Operands.getInstance().name.clear();
        Operands.getInstance().count.clear();
    }

    private MetricsEvaluator getEvaluator() {
        KeywordAnalyzer ka = new KeywordAnalyzer();
        ka.analyzeKeywords();
        SymbolAnalyzer sa = new SymbolAnalyzer();
        sa.analyzeSymbols();
        BracesAnalyzer ba = new BracesAnalyzer();
        ba.analyzeBraces();
        LiteralAnalyzer la = new LiteralAnalyzer();
        la.analyzeLiterals();
        MetricsEvaluator me = new MetricsEvaluator();
        me.evaluate();
        return me;
    }

    public MetricsEvaluator initiate(String fileURL) throws Exception {
        resetOps();
        Tokenizer.getInstance().tokenize(fileURL);

        return getEvaluator();
    }
}
