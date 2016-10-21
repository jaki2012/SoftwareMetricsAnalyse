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
        super.isStructure(graph, node);
        if (null == node || graph == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 2) {
//            nodesToRemove.add(node);
            ArrayList<Edge<V>> tmpEdge = new ArrayList<>();
            tmpEdge.addAll(edges);

            edgesToRemove.add(tmpEdge.get(0));
            edgesToRemove.add(tmpEdge.get(1));

            Node<V> leftNode = tmpEdge.get(0).getEndNode();
            Node<V> rightNode = tmpEdge.get(1).getEndNode();

            if (leftNode != null && rightNode != null) {
//                nodesToRemove.add(leftNode);
//                nodesToRemove.add(rightNode);
                tmpEdge.clear();
                edges = graph.getNodeEdges(leftNode);

                if (verify(edges, rightNode, leftNode)) {
                    graph.addEdge(node, rightNode); // add an edge from start to end
                    return true;
                }

                tmpEdge.clear();
                edges = graph.getNodeEdges(rightNode);

                if (verify(edges, leftNode, rightNode)) {
                    graph.addEdge(node, leftNode); // add an edge from start to end
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verify if the node is IfEmpty
     * @param edges edges from potential non-empty body
     * @param node potential final node
     * @param node2Remove potential removable node
     * @return if the node is IfEmpty
     */
    private boolean verify(Set<Edge<V>> edges, Node<V> node, Node<V> node2Remove) {
        if (null != edges && edges.size() == 1) {
            ArrayList<Edge<V>> tmpEdge = new ArrayList<>();
            tmpEdge.addAll(edges);
            if (tmpEdge.get(0).getEndNode().equals(node)) { // the node body is empty
                nodesToRemove.add(node2Remove);
                edgesToRemove.add(tmpEdge.get(0));
                return true;
            }
        }
        return false;
    }

}
