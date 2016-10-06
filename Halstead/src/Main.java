import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * Created by Novemser on 2016/10/6.
 */
public class Main {

    /**
     * 生成一个语法单元
     * 每个java文件对应一个语法单元
     * @param in 输入文件流
     * @return 语法单元
     */
    private static CompilationUnit getCompilationUnit(InputStream in) {
        try {
            CompilationUnit cu;
            try {
                // parse the file
                cu = JavaParser.parse(in);
                return cu;
            } finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String... args) throws Exception {
        // 默认包下一个叫Simple.java的文件 根据自己的情况更改
        String path = "E:\\MyCodes\\Java\\JavaCodeParser\\src\\Main.java";

        FileInputStream inputStream = new FileInputStream(path);

        CompilationUnit compilationUnit = getCompilationUnit(inputStream);

        assert compilationUnit != null;
        // 使用Visitor模式进行相关统计
        new CalculateVisitor().visit(compilationUnit, null);

        // 计算结果并显示
        calculateHalsteadMetrics(path);

        // 下面是测试
//        Set<Map.Entry<String, Integer>> set1 = CalculateVisitor.operands.entrySet();
//        for (Map.Entry<String, Integer> item : set1) {
//            System.out.println(item.getKey() + ":" + item.getValue());
//        }
//        set1 = CalculateVisitor.operators.entrySet();
//        for (Map.Entry<String, Integer> item : set1) {
//            System.out.println(item.getKey() + ":" + item.getValue());
//        }
    }

    private static void calculateHalsteadMetrics(String path) {
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

        System.out.println("File path:" + path);

        System.out.println(new String(new char[("File path:" + path).length()]).replace("\0", "="));

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
