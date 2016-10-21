package domain.graph.structures;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.Node;

import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/21
 */
public class ForStmt<V extends Comparable<V>> extends BaseStructure<V> {
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == graph || node == null) {
            return false;
        }

        super.isStructure(graph, node);
        Set<Edge<V>> outEdges = graph.getNodeEdges(node);
        Set<Edge<V>> inEdges = graph.getNodeEndEdges(node);

        if (outEdges != null && inEdges != null) {

            if (outEdges.size() == 2) {
                edgesToRemove.addAll(outEdges);
                Node<V> first = ((Edge<V>) outEdges.toArray()[0]).getEndNode();
                Node<V> second = ((Edge<V>) outEdges.toArray()[1]).getEndNode();

                if (first != null && second != null) {

                    if (isCircle(graph, node, first)) { // if the first node circles the for body
                        graph.addEdge(node, second);
                        return true;
                    }

                    if (isCircle(graph, node, second)) { // if the second node circles the for body
                        graph.addEdge(node, first);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isCircle(Graph<V> graph, Node<V> to, Node<V> from) {
        Set<Edge<V>> toIntermediate = graph.getNodeEdges(from);

        if (null != toIntermediate && toIntermediate.size() == 1) {
            Node<V> intermediateNode = ((Edge<V>) toIntermediate.toArray()[0]).getEndNode();

            if (null != intermediateNode) {
                Set<Edge<V>> toFinal = graph.getNodeEdges(intermediateNode);

                if (null != toFinal && toFinal.size() == 1) {
                    Node<V> finalNode = ((Edge<V>) toFinal.toArray()[0]).getEndNode();
                    if (finalNode.equals(to)) {
                        edgesToRemove.addAll(toIntermediate);
                        nodesToRemove.add(intermediateNode);
                        edgesToRemove.addAll(toFinal);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
