package domain.graph.visitors;

import adt.graph.Node;
import domain.graph.structures.CaseStmt;
import domain.graph.structures.IStructure;
import domain.graph.structures.IfStmt;
import domain.graph.structures.StructureProvider;

import java.util.Iterator;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/20
 */
public class EssComplexVisitor<V extends Comparable<V>> extends DepthFirstGraphVisitor<V> {
    private StructureProvider<V> structureProvider;

    public EssComplexVisitor() {
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new IfStmt<>());
        structureProvider.addStructure(new CaseStmt<>());
    }

    @Override
    public void handleNode(Node<V> node) {
        Iterator<IStructure<V>> iterator = structureProvider.iterator();
        while (iterator.hasNext()) {
            IStructure<V> structure = iterator.next();

            if (structure.isStructure(node))
                structure.remove(node);
        }
        super.handleNode(node);
    }
}
