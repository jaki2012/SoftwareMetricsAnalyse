package visitors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import domain.utils.ANTLRModuleStream;
import metrics.Dimension;
import metrics.Initiator;
import metrics.LOCAnalyser;
import metrics.MetricsEvaluator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Project: Halstead
 * Package: visitors
 * Author:  Novemser
 * 2016/10/22
 */
public class ModuleVisitor extends VoidVisitorAdapter {
    // Create a module template
    private String head = "public class Module {";
    private String end = "}";
    private String modulePath;
    public List<MetricsEvaluator> evaluatorList = new LinkedList<>();

    public String getModulePath() {
        return modulePath;
    }

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        StringBuilder builder = new StringBuilder();
        builder.append(head);
        builder.append(n.toString());
        builder.append(end);
        ANTLRModuleStream stream = new ANTLRModuleStream(builder.toString().toCharArray());
        try {
            MetricsEvaluator e = (new Initiator()).initiate(stream);
            InputStream inputStream = new ByteArrayInputStream(builder.toString().getBytes());
            LOCAnalyser.run(inputStream, e);
            GraphBuildVisitor graphBuildVisitor = new GraphBuildVisitor(e, n.getName(), evaluatorList);
            graphBuildVisitor.setModulePath(modulePath);
            graphBuildVisitor.visit(n, arg);
            // Calculate circle dependency
            LOCAnalyser.calculate(
                    e,
                    e.getDimension(Dimension.NUMBER_OF_LINES),
                    e.getDimension(Dimension.LOC_BLANK),
                    e.getDimension(Dimension.LOC_COMMENTS),
                    e.getDimension(Dimension.LOC_EXECUTABLE)
            );
//            System.out.println(modulePath);
            e.setModulePath(modulePath);
            evaluatorList.add(e);
//            printResult(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void printResult(MetricsEvaluator evaluator) {
//        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Dimension, Double> entry : evaluator.dimensions.entrySet()) {
//            builder.append(entry.getValue());
//            builder.append(",");
            String s = String.format("%-35s%-5s", entry.getKey(), entry.getValue());
            System.out.println(s);
        }
//        builder.append("\n");
//        if (test.Main.printWriter != null)
//            test.Main.printWriter.write(builder.toString());

    }
}
