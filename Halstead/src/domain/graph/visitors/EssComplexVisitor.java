package domain.graph.visitors;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
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
        System.out.println("B4:");
        GraphBuildVisitor.printEdges(sourceGraph);
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new IfStmt<>());
        structureProvider.addStructure(new SwitchCaseStmt<>());
        structureProvider.addStructure(new IfEmpty<>());
        structureProvider.addStructure(new Sequence3<>());
        structureProvider.addStructure(new ForStmt<>());
        structureProvider.addStructure(new WhileStmt<>());
        structureProvider.addStructure(new ForEachStmt<>());
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
        if (edgesToRemove.size() != 0 || nodesToRemove.size() != 0) {
            edgesToRemove.forEach(graph::removeEdge); // first remove all connected nodes
            nodesToRemove.forEach(graph::removeNode);
            edgesToRemove.clear();
            nodesToRemove.clear();

            for (Node<V> n : graph.getNodes()) // remove all disconnected nodes
                if (graph.getNodeEndEdges(n).size() == 0 && !graph.isInitialNode(n) && !nodesToRemove.contains(n)) {
                    edgesToRemove.addAll(graph.getNodeEdges(n));
                    nodesToRemove.add(n);
                }

            edgesToRemove.forEach(graph::removeEdge);
            nodesToRemove.forEach(graph::removeNode);

            // perform another DFS removing
            visitedNodes.clear();
            graph.accept(this);
        }
        else {
            System.out.println("Reduced:");
            GraphBuildVisitor.printEdges(graph);
        }

    }
}
