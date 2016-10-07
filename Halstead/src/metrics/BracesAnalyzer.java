package metrics;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class BracesAnalyzer {
    String[][] braces = new String[][]{{"{", "}"}, {"(", ")"}, {"[", "]"}, {"<", ">"}};

    public BracesAnalyzer() {
    }

    public int countbraces(int index) {
        int counter = 0;
        int startCount = 0;
        int endCount = 0;

        for(int i = 0; i < Tokenizer.getInstance().tokens.size(); ++i) {
            if(((String)Tokenizer.getInstance().tokens.get(i)).toString().equals(this.braces[index][0])) {
                ++startCount;
            } else if(((String)Tokenizer.getInstance().tokens.get(i)).toString().equals(this.braces[index][1])) {
                ++endCount;
            }
        }

        if(startCount == endCount) {
            counter = startCount;
        }

        return counter;
    }

    public void analyzeBraces() {
        for(int i = 0; i < this.braces.length; ++i) {
            int count = this.countbraces(i);
            if(count > 0) {
                Operators.getInstance().insert(this.braces[i][0] + " " + this.braces[i][1], count);
            }
        }

    }

}
