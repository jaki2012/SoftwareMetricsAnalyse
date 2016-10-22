package domain.graph.structures.rules;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.BaseStructure;

import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures.rules
 * Author:  Novemser
 * 2016/10/22
 */
public class Looping<V extends Comparable<V>> extends BaseStructure<V> {
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node
                || graph == null
                || node.isContainMethodCall()
                || graph.getNodeEdges(node).size() != 1
                || graph.getNodeEndEdges(node).size() != 2) { // loop condition
            return false;
        }
        super.isStructure(graph, node);
        Set<Edge<V>> edges = graph.getNodeEdges(node);

        if (null != edges && edges.size() == 1) {
            Node<V> next = ((Edge<V>)edges.toArray()[0]).getEndNode();
        }

        return false;
    }
}
