package domain.graph.structures;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class Sequence3<V extends Comparable<V>> extends BaseStructure<V> {
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        super.isStructure(graph, node);
        if (null == node || graph == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 1) {
            edgesToRemove.addAll(edges);
            Node<V> nextNode = ((Edge<V>) edges.toArray()[0]).getEndNode(); // next node
            nodesToRemove.add(nextNode);

            if (null != nextNode) {
                edges = graph.getNodeEdges(nextNode);

                if (edges != null && edges.size() == 1) {
                    edgesToRemove.addAll(edges);
                    nextNode = ((Edge<V>) edges.toArray()[0]).getEndNode(); // final node

                    if (nextNode != null) {
                        Set<Edge<V>> toStartEdges = graph.getNodeEdges(nextNode);
                        if (toStartEdges.size() > 0) {
                            for (Edge<V> edge : toStartEdges) {
                                if (edge.getEndNode().equals(node))
                                    return false;
                            }
                        }
                        graph.addEdge(node, nextNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
