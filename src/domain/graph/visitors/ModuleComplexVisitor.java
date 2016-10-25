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
//        System.out.println("B4:");
//        GraphBuildVisitor.printEdges(sourceGraph);
        String method = "isContainMethodCall";
        structureProvider = new StructureProvider<>();
//        structureProvider.addStructure(new Sequential<>(method));
//        structureProvider.addStructure(new Conditional<>(method));
        structureProvider.addStructure(new Looping<>(method));
        structureProvider.addStructure(new Repetitive<>(method));
        structureProvider.addStructure(new IfStmtNCall<>(method));
        graph = sourceGraph;
    }
}
