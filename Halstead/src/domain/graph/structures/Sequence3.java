package domain.graph.structures;

import adt.graph.Graph;
import adt.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class Sequence3<V extends Comparable<V>> extends BaseStructure<V> implements IStructure<V> {
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        return false;
    }
}
