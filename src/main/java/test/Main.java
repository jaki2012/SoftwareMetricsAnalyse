package test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.commons.io.FilenameUtils;
import visitors.CalculateVisitor;
import visitors.ModuleVisitor;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Project: Halstead
 * Package: ${PACKAGE_NAME}
 * Author:  Novemser
 * 2016/10/6
 */
public class Main {

    public static PrintWriter printWriter;
    public static int cnt;

    public static void run(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Dir:" + file.getAbsolutePath());
                run(file.listFiles()); // Calls same method again.
            } else {
                try {
                    if (FilenameUtils.getExtension(file.getCanonicalPath()).equals("java")) {
                        System.out.println("File " + cnt + " :" + file.getName() + " calculation...");
                        calculate(file.getAbsolutePath());
                        System.out.println("File " + ++cnt + " :" + file.getName() + " calculated successful");
                        printWriter.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... args) throws Exception {
//        String initPath = "I:\\GitUnzipped";
//        printWriter  = new PrintWriter(new File("F:\\DataComplex-edge-g-10.csv"));
//        run(new File(initPath).listFiles());
        // 默认包下一个叫Simple.java的文件 根据况更改
        String simple = "F:\\simple.java";
        String path = "I:\\GitUnzipped\\antlr-antlr4-e9aa00e\\runtime-testsuite\\test\\org\\antlr\\v4\\test\\runtime\\javascript\\node\\TestLexerExec.java";

//        System.out.println("File path:" + simple);
//        System.out.println(new String(new char[("File path:" + path).length()]).replace("\0", "="));
        calculate(simple);
    }

    @SuppressWarnings("unchecked")
    private static void calculate(String path) throws Exception {
        //CompilationUnit unit = JavaParser.parse(new FileInputStream(path));
        CompilationUnit unit = JavaParser.parse(prePerceeding(new FileInputStream(path)));

        new ModuleVisitor().visit(unit, null);
    }

    private static ByteArrayInputStream prePerceeding(FileInputStream originFIS){
        StringBuilder listOfLines = new StringBuilder("");
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(originFIS));
            String temp;
            do{
                temp = bufferedReader.readLine();
                if(temp != null){
                    //Add additional '\n' for the '\n' loss of readLine()
                    if(0 == temp.trim().length()){
                        listOfLines.append("//BlankLine!!\n");
                    }else{
                        listOfLines.append(temp+'\n');
                    }
                }
            }while (temp!=null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream handledFIS = null;
        try {
            handledFIS = new ByteArrayInputStream(listOfLines.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return handledFIS;
    }


    @Deprecated
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
