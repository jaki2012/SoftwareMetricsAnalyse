import com.github.javaparser.ast.CompilationUnit;
import metrics.Initiator;
import metrics.MetricsEvaluator;
import visitors.CalculateVisitor;

import java.util.Map;
import java.util.Set;

/**
 * Created by Novemser on 2016/10/6.
 */
public class Main {

//    /**
//     * 生成一个语法单元
//     * 每个java文件对应一个语法单元
//     * @param in 输入文件流
//     * @return 语法单元
//     */
//    private static CompilationUnit getCompilationUnit(InputStream in) {
//        try {
//            CompilationUnit cu;
//            try {
//                // parse the file
//                cu = JavaParser.parse(in);
//                return cu;
//            } finally {
//                in.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static void main(String... args) throws Exception {
        // 默认包下一个叫Simple.java的文件 根据自己的情况更改
        String path = "E:\\MyCodes\\Java\\FileSys\\src\\simple.java";
        System.out.println("File path:" + path);
        System.out.println(new String(new char[("File path:" + path).length()]).replace("\0", "="));
//        String f = "E:\\MyCodes\\Java\\FileSys\\src\\simple.java";
        // 计算结果并显示
//        calculateHalsteadMetrics(path);

        calculateHalsteadMetricsV2(path);

//        Lexer lexer = new JavaLexer(new ANTLRFileStream(f));
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        JavaParser parser = new JavaParser(tokens);
//        ParserRuleContext tree = parser.compilationUnit();
//
//        CyclomaticComplexityVisitor mv = new CyclomaticComplexityVisitor();
//        mv.visit(tree);
        // 下面是测试
//        Set<Map.Entry<String, Integer>> set1 = visitors.CalculateVisitor.operands.entrySet();
//        for (Map.Entry<String, Integer> item : set1) {
//            System.out.println(item.getKey() + ":" + item.getValue());
//        }
//        set1 = visitors.CalculateVisitor.operators.entrySet();
//        for (Map.Entry<String, Integer> item : set1) {
//            System.out.println(item.getKey() + ":" + item.getValue());
//        }
    }

    private static void calculateHalsteadMetricsV2(String path) throws Exception {
        MetricsEvaluator e = (new Initiator()).initiate(path);

        System.out.println("n1:\t\t\t\t\t\t\t\t" + e.n1);
        System.out.println("n2:\t\t\t\t\t\t\t\t" + e.n2);
        System.out.println("n(Program Vocabulary):\t\t\t" + e.PROGRAM_VOCABULARY);

        System.out.println("N1:\t\t\t\t\t\t\t\t" + e.N1);
        System.out.println("N2:\t\t\t\t\t\t\t\t" + e.N2);
        System.out.println("N(Program length):\t\t\t\t" + e.PROGRAM_LENGTH);

        System.out.println("Calculated program length:\t\t" + e.ESTIMATED_LENGTH);
        System.out.println("Volume:\t\t\t\t\t\t\t" + e.VOLUME);
        System.out.println("Difficulty:\t\t\t\t\t\t" + e.DIFFICULTY);
        System.out.println("Effort:\t\t\t\t\t\t\t" + e.PROGRAM_EFFORT);
        System.out.println("Time required to program:\t\t" + e.PROGRAMMING_TIME);
        System.out.println("Purity ratio:\t\t\t\t\t" + e.PURITY_RATIO);
    }

//    private static void runSimpleTest(String path) throws FileNotFoundException {
//        FileInputStream inputStream = new FileInputStream(path);
//
//        CompilationUnit compilationUnit = getCompilationUnit(inputStream);
//
//        assert compilationUnit != null;
//        // 使用Visitor模式进行相关统计
//        new CalculateVisitor().visit(compilationUnit, null);
//    }

    private static void calculateHalsteadMetrics(String path) {
//        try {
//            runSimpleTest(path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        int n1, n2, n, N1 = 0, N2 = 0, N;
        double CPL, V, D, E;
        n1 = CalculateVisitor.operators.size();
        n2 = CalculateVisitor.operands.size();
        n = n1 + n2;

        Set<Map.Entry<String, Integer>> operatorSet = CalculateVisitor.operators.entrySet();
        Set<Map.Entry<String, Integer>> operandSet = CalculateVisitor.operands.entrySet();

        for (Map.Entry<String, Integer> item : operatorSet) {
            N1 += item.getValue();
        }
        for (Map.Entry<String, Integer> item : operandSet) {
            N2 += item.getValue();
        }

        N = N1 + N2;

        CPL = n1 * Math.log(n1) / Math.log(2) + n2 * Math.log(n2) / Math.log(2);

        V = N * Math.log(n) / Math.log(2);

        D = n1 * N2 / (2 * n2);

        E = D * V;

        System.out.println("n1:" + n1);
        System.out.println("n2:" + n2);
        System.out.println("n:" + n);
        System.out.println("N1:" + N1);
        System.out.println("N2:" + N2);
        System.out.println("N:" + N);
        System.out.println("CPL:" + CPL);
        System.out.println("V:" + V);
        System.out.println("D:" + D);
        System.out.println("E:" + E);
    }

}
