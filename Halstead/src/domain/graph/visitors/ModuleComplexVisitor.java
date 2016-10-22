package domain.graph.visitors;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.*;
import domain.graph.structures.rules.*;
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
public class ModuleComplexVisitor<V extends Comparable<V>> extends AbstractMcCabeVisitor<V> {

    public ModuleComplexVisitor(Graph<V> sourceGraph) {
        System.out.println("B4:");
        GraphBuildVisitor.printEdges(sourceGraph);
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new Sequential<V>());
        structureProvider.addStructure(new Conditional<V>());
        structureProvider.addStructure(new Looping<V>());
        structureProvider.addStructure(new Repetitive<V>());
        structureProvider.addStructure(new IfStmtNCall<>());
        graph = sourceGraph;
    }
}
