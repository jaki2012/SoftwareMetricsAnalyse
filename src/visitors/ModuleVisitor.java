package visitors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import domain.utils.ANTLRModuleStream;
import metrics.Initiator;
import metrics.MetricsEvaluator;

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
        System.out.println("======================================");
        System.out.println("Module name:" + n.getName());
        StringBuilder builder = new StringBuilder();
        builder.append(head);
        builder.append(n.toString());
        builder.append(end);
        ANTLRModuleStream stream = new ANTLRModuleStream(builder.toString().toCharArray());
        try {
            MetricsEvaluator e = (new Initiator()).initiate(stream);
            new GraphBuildVisitor(e).visit(n, arg);

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
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }
}
