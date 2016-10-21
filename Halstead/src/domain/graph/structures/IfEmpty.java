package domain.graph.structures;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.Node;

import java.util.ArrayList;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class IfEmpty<V extends Comparable<V>> extends BaseStructure<V> implements IStructure<V> {

    /**
     * If the node down here is a
     * statement without
     * 'if-then' body or
     * 'else' body.
     * @param graph the graph to process
     * @param node  the node to determine
     * @return true means yes vice versa
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node || graph == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 2) {
            ArrayList<Edge<V>> tmpEdge = new ArrayList<>();
            tmpEdge.addAll(edges);
            Node<V> leftNode = tmpEdge.get(0).getEndNode();
            Node<V> rightNode = tmpEdge.get(1).getEndNode();

            if (leftNode != null && rightNode != null) {
                tmpEdge.clear();
                edges = graph.getNodeEdges(leftNode);

                if (null != edges && edges.size() == 1) {
                    tmpEdge.addAll(edges);
                    if (tmpEdge.get(0).getEndNode().equals(rightNode)) { // the else body is empty
                        return true;
                    }
                }

                tmpEdge.clear();
                edges = graph.getNodeEdges(rightNode);

                if (null != edges && edges.size() == 1) {
                    tmpEdge.addAll(edges);
                    if (tmpEdge.get(0).getEndNode().equals(leftNode)) { // the if body is empty
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
