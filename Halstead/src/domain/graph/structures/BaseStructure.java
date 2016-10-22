package domain.graph.structures;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/21
 */
public class BaseStructure<V extends Comparable<V>> implements IStructure<V> {
    protected Set<Node<V>> nodesToRemove = new HashSet<>();
    protected Set<Edge<V>> edgesToRemove = new HashSet<>();

    /**
     * Perform cleaning to temp data sets.
     */
    private void clean() {
        nodesToRemove.clear();
        edgesToRemove.clear();
    }

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        clean();
        return false;
    }

    @Override
    public Set<Node<V>> getRemovableNodes() {
        return nodesToRemove;
    }

    @Override
    public Set<Edge<V>> getRemovableEdges() {
        return edgesToRemove;
    }
}
