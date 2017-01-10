package com.tongji409;

import GithubParserUtils.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import metrics.MetricsEvaluator;
import org.apache.commons.io.FilenameUtils;
import visitors.ModuleVisitor;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Project: SoftwareMetricsAnalyse
 * Package: com.tongji409
 * Author:  Novemser
 * 2016/12/15
 */
public class DimensionCalculator {

    private boolean debug;

    public void enableDebugMode() {
        debug = true;
    }

    public void disableDebugMode() {
        debug = false;
    }

    public List<List<MetricsEvaluator>> getProjectMetrics() {
        return projectMetrics;
    }

    private List<List<MetricsEvaluator>> projectMetrics = new LinkedList<>();

    public void calculateFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                calculateFiles(file.listFiles()); // Calls same method again.
            } else {
                try {
                    if (FilenameUtils.getExtension(file.getCanonicalPath()).equals("java")) {
                        projectMetrics.add(calculate(file.getAbsolutePath()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... args) throws Exception {
//        String initPath = "I:\\GitUnzipped";
//        printWriter  = new PrintWriter(new File("F:\\Test-1min.csv"));
//        run(new File(initPath).listFiles());
        // 默认包下一个叫Simple.java的文件 根据况更改
        String simple = "F:\\simple.java";
        String path = "I:\\GitUnzipped\\antlr-antlr4-e9aa00e\\runtime-testsuite\\test\\org\\antlr\\v4\\test\\runtime\\javascript\\node\\TestLexerExec.java";
        String test = "E:\\MyCodes\\Java\\FileSys\\src\\FileManager.java";
//        System.out.println("File path:" + simple);
//        System.out.println(new String(new char[("File path:" + path).length()]).replace("\0", "="));
        new DimensionCalculator().calculate(simple);
    }

    @SuppressWarnings("unchecked")
    private List<MetricsEvaluator> calculate(String path) throws Exception {
        FileInputStream stream = new FileInputStream(path);
        CompilationUnit unit = JavaParser.parse(preProceeding(stream));

        ModuleVisitor visitor = new ModuleVisitor();
        visitor.setModulePath(path);
        visitor.visit(unit, null);

        if (debug)
            System.out.println("Eve size" + visitor.evaluatorList.size());

        stream.close();
        return visitor.evaluatorList;
    }

    private ByteArrayInputStream preProceeding(FileInputStream originFIS) {
        StringBuilder listOfLines = new StringBuilder("");
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(originFIS));
            String temp;
            do {
                temp = bufferedReader.readLine();
                if (temp != null) {
                    //Add additional '\n' for the '\n' loss of readLine()
                    if (0 == temp.trim().length()) {
                        listOfLines.append("//BlankLine!!\n");
                    } else {
                        listOfLines.append(temp).append('\n');
                    }
                }
            } while (temp != null);

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
}
