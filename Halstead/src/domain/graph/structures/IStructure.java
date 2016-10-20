package domain.graph.structures;

import adt.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public interface IStructure<V extends Comparable<V>> {
    boolean isStructure(Node<V> node);
    void remove(Node<V> node);
}
