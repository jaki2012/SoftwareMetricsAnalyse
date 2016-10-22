package domain.graph.structures.rules;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.BaseStructure;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures.rules
 * Author:  Novemser
 * 2016/10/22
 */
public class Repetitive<V extends Comparable<V>> extends BaseRule<V> {
    public Repetitive(String method) {
        super(method);
    }

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        try {
            if (null == node
                    || graph == null
                    || (boolean) method.invoke(node))
                return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        super.isStructure(graph, node);
        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 1) {
            Node<V> finalNode = ((Edge<V>)edges.toArray()[0]).getEndNode();
            if (null != finalNode) {
                if (finalNode.equals(node)) { // repetitive rule
                    edgesToRemove.addAll(edges);
                    return true;
                }
            }
        }

        return false;
    }
}
