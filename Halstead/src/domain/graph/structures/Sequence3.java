package domain.graph.structures;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.Node;

import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class Sequence3<V extends Comparable<V>> extends BaseStructure<V> implements IStructure<V> {
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
                        graph.addEdge(node, nextNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
