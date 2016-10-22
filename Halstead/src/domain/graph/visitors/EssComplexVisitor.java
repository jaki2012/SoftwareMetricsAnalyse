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
public class EssComplexVisitor<V extends Comparable<V>> extends AbstractMcCabeVisitor<V> {

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
}
