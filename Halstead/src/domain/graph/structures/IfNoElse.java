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
public class IfNoElse<V extends Comparable<V>> implements IStructure<V> {

    /**
     * If the node down here is a
     * 'if' statement without 'else'.
     * @param graph the graph to process
     * @param node the node to determine
     * @return true means yes vice versa
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isStructure(Graph graph, Node node) {
        if (null == node || graph == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 2) {

        }
        return false;
    }

    @Override
    public void remove(Graph graph, Node node) {

    }
}
