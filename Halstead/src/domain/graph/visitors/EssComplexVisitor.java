package domain.graph.visitors;

import adt.graph.Graph;
import adt.graph.Node;
import domain.graph.structures.*;

import java.util.Iterator;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/20
 */
public class EssComplexVisitor<V extends Comparable<V>> extends DepthFirstGraphVisitor<V> {
    private StructureProvider<V> structureProvider;
    private Graph<V> graph;

    public EssComplexVisitor(Graph<V> sourceGraph) {
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new IfStmt<>());
        structureProvider.addStructure(new CaseStmt<>());
        structureProvider.addStructure(new IfNoElse<>());
        graph = sourceGraph;
    }

    @Override
    public void handleNode(Node<V> node) {
        Iterator<IStructure<V>> iterator = structureProvider.iterator();
        while (iterator.hasNext()) {
            IStructure<V> structure = iterator.next();

            if (structure.isStructure(graph, node))
                structure.remove(graph, node);
        }
    }
}
