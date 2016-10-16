package metrics;

import metrics.java7.JavaBaseVisitor;
import visitors.CyclomaticComplexityVisitor;

/**
 * Project: Halstead
 * Package: PACKAGE_NAME
 * Author:  Novemser
 * 2016/10/7
 */
public class Initiator {
    public Initiator() {
    }

    public MetricsEvaluator initiate(String fileURL) throws Exception {
        Operators.getInstance().count.clear();
        Operators.getInstance().name.clear();
        Operands.getInstance().name.clear();
        Operands.getInstance().count.clear();
        Tokenizer.getInstance().tokenize(fileURL);
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
        JavaBaseVisitor visitor = new CyclomaticComplexityVisitor(me);
        visitor.visit(Tokenizer.tree);
        return me;
    }
}
