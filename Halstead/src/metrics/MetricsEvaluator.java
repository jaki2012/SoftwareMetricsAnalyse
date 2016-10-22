package metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Halstead
 * Package: ${PACKAGE_NAME}
 * Author:  Novemser
 * 2016/10/7
 */
public class MetricsEvaluator {
//    public double BRANCH_COUNT;
//    public double CALL_PAIRS;
//    public int MULTI_CONDITION_COUNT;
//    public int MODIFIED_CONDITION_COUNT;
//    public int globalParameters;
//    public int CONDITION_COUNT;
//    public int CYCLOMATIC_COMPLEXITY;
//    public int CYCLOMATIC_DENSITY;
//    public int DECISION_COUNT;
//    public int DECISION_DENSITY;

    public double PROGRAM_LENGTH;
    public double PROGRAM_VOCABULARY;
    public double ESTIMATED_LENGTH;
    public double PURITY_RATIO;
    public double VOLUME;
    public double DIFFICULTY;
    public double PROGRAM_EFFORT;
    public double PROGRAMMING_TIME;
    public double DERIVED_BUGS;
    public double n1;
    public double n2;
    public double N1;
    public double N2;
    public Map<Dimension, Double> dimensions;

    public MetricsEvaluator() {
        dimensions = new HashMap<>();
        // add all dimensions to a map
        for (Dimension dimension : Dimension.values()) {
            dimensions.put(dimension, 0.0);
        }
    }

    public void putDimension(Dimension dimension, Double value) {
        dimensions.put(dimension, value);
    }

    public Double getDimension(Dimension dimension) {
        return dimensions.get(dimension);
    }

    public void evaluate() {
        this.N1 = (double)Operators.getInstance().name.size();
        this.N2 = (double)Operands.getInstance().name.size();

        int i;
        for(i = 0; i < Operators.getInstance().name.size(); ++i) {
            this.n1 += (double)Integer.parseInt(((String)Operators.getInstance().count.get(i)).toString());
        }

        for(i = 0; i < Operands.getInstance().name.size(); ++i) {
            this.n2 += (double)Integer.parseInt(((String)Operands.getInstance().count.get(i)).toString());
        }

        this.PROGRAM_LENGTH = this.N1 + this.N2;
        this.PROGRAM_VOCABULARY = this.n1 + this.n2;
        this.ESTIMATED_LENGTH = this.n1 * (Math.log(this.n1) / Math.log(2.0D)) + this.n2 * (Math.log(this.n2) / Math.log(2.0D));
        this.PURITY_RATIO = this.ESTIMATED_LENGTH / this.PROGRAM_LENGTH;
        this.VOLUME = this.PROGRAM_LENGTH * (Math.log(this.PROGRAM_LENGTH) / Math.log(2.0D));
        this.DIFFICULTY = this.n1 / 2.0D * (this.N2 / this.n2);
        this.PROGRAM_EFFORT = this.VOLUME * this.DIFFICULTY;
        this.PROGRAMMING_TIME = this.PROGRAM_EFFORT / 18.0D;
        DERIVED_BUGS = VOLUME / 3000;

    }

}
