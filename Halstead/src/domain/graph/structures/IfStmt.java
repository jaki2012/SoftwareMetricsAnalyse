package domain.graph.structures;

import adt.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class IfStmt<V extends Comparable<V>> implements IStructure<V> {

    @Override
    public boolean isStructure(Node<V> node) {
        return false;
    }

    @Override
    public void remove(Node<V> node) {

    }
}
