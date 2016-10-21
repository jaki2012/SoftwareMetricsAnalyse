package domain.graph.visitors;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.Node;
import domain.graph.structures.*;
import visitors.GraphBuildVisitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/20
 */
public class EssComplexVisitor<V extends Comparable<V>> extends DepthFirstGraphVisitor<V> {
    private StructureProvider<V> structureProvider;
    private Graph<V> graph;
    private Set<Node<V>> nodesToRemove = new HashSet<>();
    private Set<Edge<V>> edgesToRemove = new HashSet<>();

    public EssComplexVisitor(Graph<V> sourceGraph) {
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new IfStmt<>());
        structureProvider.addStructure(new SwitchCaseStmt<>());
        structureProvider.addStructure(new IfEmpty<>());
        graph = sourceGraph;
    }

    @Override
    public void handleNode(Node<V> node) {
        Iterator<IStructure<V>> iterator = structureProvider.iterator();
        while (iterator.hasNext()) {
            IStructure<V> structure = iterator.next();

            if (structure.isStructure(graph, node)) {
                nodesToRemove.addAll(structure.getRemovableNodes());
                edgesToRemove.addAll(structure.getRemovableEdges());
            }
        }
    }

    @Override
    public void endVisit(Graph<V> graph) {
        System.out.println("B4:");
        GraphBuildVisitor.printEdges(graph);
        if (edgesToRemove.size() != 0 && nodesToRemove.size() != 0) {
            edgesToRemove.forEach(graph::removeEdge);
            nodesToRemove.forEach(graph::removeNode);
            edgesToRemove.clear();
            nodesToRemove.clear();
            // perform another DFS removing
            graph.accept(this);
        }
        System.out.println("Af:");
        GraphBuildVisitor.printEdges(graph);
    }
}
