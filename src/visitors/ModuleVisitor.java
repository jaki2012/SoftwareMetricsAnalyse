package visitors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import domain.utils.ANTLRModuleStream;
import metrics.Initiator;
import metrics.LOCAnalyser;
import metrics.MetricsEvaluator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Project: Halstead
 * Package: visitors
 * Author:  Novemser
 * 2016/10/22
 */
public class ModuleVisitor extends VoidVisitorAdapter {
    // Create a module template
    String head = "public class Module {";
    String end = "}";

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
            LOCAnalyser.calculate(inputStream, e);
            new GraphBuildVisitor(e, n.getName()).visit(n, arg);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }
}
