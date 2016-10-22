package domain.graph.visitors;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.IStructure;
import domain.graph.structures.StructureProvider;
import visitors.GraphBuildVisitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/22
 */
public class AbstractMcCabeVisitor<V extends Comparable<V>> extends DepthFirstGraphVisitor<V> {
    protected StructureProvider<V> structureProvider;
    protected Graph<V> graph;
    protected Set<Node<V>> nodesToRemove = new HashSet<>();
    protected Set<Edge<V>> edgesToRemove = new HashSet<>();

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
