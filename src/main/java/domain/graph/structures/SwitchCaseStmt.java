package domain.graph.structures;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

import java.util.*;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class SwitchCaseStmt<V extends Comparable<V>> extends BaseStructure<V> {
    private Map<Node<V>, Integer> originFinalNodes = new TreeMap<>();

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node || graph == null)
            return false;

        super.isStructure(graph, node);
        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() > 2) { // if size == 2, IfStmt will do the work
//            nodesToRemove.add(node);
            List<Edge<V>> tmpEdge = new ArrayList<>();
            tmpEdge.addAll(edges);
            edgesToRemove.addAll(edges);
            List<Node<V>> tmpNode = new ArrayList<>();
            List<Edge<V>> finalEdges = new ArrayList<>();
            for (Edge<V> edge : tmpEdge) {
                Node<V> caseNode = edge.getEndNode();

                if (graph.getNodeEdges(caseNode).size() == 1) { // smallest part of case statement
                    nodesToRemove.add(caseNode);
                    tmpNode.add(caseNode);
                    finalEdges.addAll(graph.getNodeEdges(caseNode));
                    edgesToRemove.addAll(graph.getNodeEdges(caseNode));
                }
            }

            originFinalNodes.clear();
            if (finalEdges.size() != 0) {
                for (Edge<V> finalEdge : finalEdges) {
                    Node<V> lastNode = finalEdge.getEndNode();

                    if (lastNode != null) {

                        if (!originFinalNodes.containsKey(lastNode)) {
                            originFinalNodes.put(lastNode, 1);
                        } else {
                            originFinalNodes.put(lastNode, originFinalNodes.get(lastNode) + 1);
                        }
                    }
                }
            }

            for (Map.Entry<Node<V>, Integer> entry : originFinalNodes.entrySet()) {

                if (entry.getValue() > 1) {
                    graph.addEdge(node, entry.getKey()); // add an edge from origin to end
                    return true;
                }
            }

        }

        return false;
    }

}
