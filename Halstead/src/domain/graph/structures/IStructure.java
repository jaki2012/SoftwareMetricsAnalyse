package domain.graph.structures;

import adt.graph.Graph;
import adt.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public interface IStructure<V extends Comparable<V>> {
    boolean isStructure(Graph<V> graph, Node<V> node);
    void remove(Graph<V> graph, Node<V> node);
}
