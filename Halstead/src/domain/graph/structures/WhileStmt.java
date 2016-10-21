package domain.graph.structures;

import adt.graph.Graph;
import adt.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/21
 */
public class WhileStmt<V extends Comparable<V>> extends BaseStructure<V> {
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        return super.isStructure(graph, node);
    }
}
