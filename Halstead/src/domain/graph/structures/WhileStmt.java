package domain.graph.structures;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/21
 */
public class WhileStmt<V extends Comparable<V>> extends BaseStructure<V> {

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
                    Set<Edge<V>> toFinalEdge = graph.getNodeEdges(first);
                    if (isLoop(node, first, toFinalEdge)) return true;

                    toFinalEdge = graph.getNodeEdges(second);
                    if (isLoop(node, second, toFinalEdge)) return true;
                }
            }
        }

        return false;
    }

    private boolean isLoop(Node<V> node, Node<V> second, Set<Edge<V>> toFinalEdge) {
        if (toFinalEdge.size() == 1) {
            Edge<V> toFinal = ((Edge<V>)toFinalEdge.toArray()[0]);
            Node<V> finalNode = toFinal.getEndNode();
            if (null != finalNode && finalNode.equals(node)) {
                nodesToRemove.add(second);
                edgesToRemove.add(toFinal);
                return true;
            }
        }
        return false;
    }
}
