package domain.graph.visitors;

import ast.graph.Graph;
import domain.graph.structures.StructureProvider;
import domain.graph.structures.rules.*;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/22
 */
public class DataComplexVisitor<V extends Comparable<V>> extends AbstractMcCabeVisitor<V> {

    public DataComplexVisitor(Graph<V> sourceGraph) {
        String method = "isContainsParamCall";
        structureProvider = new StructureProvider<>();
        structureProvider.addStructure(new Sequential<>(method));
        structureProvider.addStructure(new Conditional<>(method));
        structureProvider.addStructure(new Looping<>(method));
        structureProvider.addStructure(new Repetitive<>(method));
        structureProvider.addStructure(new IfStmtNCall<>(method));
        graph = sourceGraph;
    }
}
