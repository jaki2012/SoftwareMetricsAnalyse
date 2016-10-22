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
public class Sequential<V extends Comparable<V>> extends BaseStructure<V> {

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node || graph == null) {
            return false;
        }
        super.isStructure(graph, node);

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 1) {
            Node<V> nextNode = ((Edge<V>) edges.toArray()[0]).getEndNode(); // next node

            if (null != nextNode) {
                if (!nextNode.isContainMethodCall()) {
                    nodesToRemove.add(nextNode);
                    edges = graph.getNodeEdges(nextNode);

                    if (edges != null && edges.size() == 1) {
                        nextNode = ((Edge<V>) edges.toArray()[0]).getEndNode(); // final node

                        if (nextNode != null) {
                            Set<Edge<V>> toStartEdges = graph.getNodeEdges(nextNode);
                            if (toStartEdges.size() > 0) {
                                for (Edge<V> edge : toStartEdges) {
                                    if (edge.getEndNode().equals(node))
                                        return false;
                                }
                            }
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }
}
