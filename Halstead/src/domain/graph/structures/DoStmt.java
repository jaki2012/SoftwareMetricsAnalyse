package domain.graph.structures;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/22
 */
public class DoStmt<V extends Comparable<V>> extends BaseStructure<V> {

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == graph || node == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 1) {
            edgesToRemove.addAll(edges);
            Node<V> nodeWhile = ((Edge<V>) edges.toArray()[0]).getEndNode();
            if (null != nodeWhile) {
                edges = graph.getNodeEdges(nodeWhile);
                nodesToRemove.add(nodeWhile);

                if (edges.size() == 2) { // one to begin one to end
                    edgesToRemove.addAll(edges);
                    Node<V> first = ((Edge<V>) edges.toArray()[0]).getEndNode();
                    Node<V> second = ((Edge<V>) edges.toArray()[1]).getEndNode();

                    if (first.equals(node)) {
                        graph.addEdge(node, second);
                        return true;
                    }
                    if (second.equals(node)) {
                        graph.addEdge(node, first);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
