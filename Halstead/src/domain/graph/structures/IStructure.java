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
public interface IStructure<V extends Comparable<V>> {
    boolean isStructure(Graph<V> graph, Node<V> node);
    Set<Node<V>> getRemovableNodes();
    Set<Edge<V>> getRemovableEdges();
}
