package domain.graph.structures;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.Node;

import java.util.*;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class IfStmt<V extends Comparable<V>> extends BaseStructure<V> implements IStructure<V> {

    /**
     * If the node down here is a
     * `if` statement.
     * @param graph the graph to process
     * @param node the node to determine
     * @return true means yes vice versa
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node || graph == null)
            return false;

        Set<Edge<V>> edges = graph.getNodeEdges(node);
        if (null != edges && edges.size() == 2) {
            nodesToRemove.add(node);
            ArrayList<Edge<V>> tmpEdge = new ArrayList<>();
            tmpEdge.addAll(edges);
            edgesToRemove.add(tmpEdge.get(0));
            edgesToRemove.add(tmpEdge.get(1));

            Node<V> leftNode = tmpEdge.get(0).getEndNode();
            Node<V> rightNode = tmpEdge.get(1).getEndNode();

            // Get the branches of if statement
            if (leftNode != null && rightNode != null) {
                nodesToRemove.add(leftNode);
                nodesToRemove.add(rightNode);

                tmpEdge.clear();
                Node<V> leftFinal, rightFinal;
                edges = graph.getNodeEdges(leftNode); // get end nodes of left node

                if (null != edges && edges.size() == 1) { // if left node only has one edge
                    tmpEdge.addAll(edges);
                    leftFinal = tmpEdge.get(0).getEndNode(); // get left final node
                    edgesToRemove.add(tmpEdge.get(0));
                    nodesToRemove.add(leftFinal);
                    tmpEdge.clear();

                    if (leftFinal != null) {
                        edges = graph.getNodeEdges(rightNode);

                        if (null != edges && edges.size() == 1) { // if right node only has one edge
                            tmpEdge.addAll(edges);
                            edgesToRemove.add(tmpEdge.get(0));
                            rightFinal = tmpEdge.get(0).getEndNode(); // get right final node

                            if (leftFinal.equals(rightFinal)) { // if left final && right final are equal
                                return true;
                            }
                        }
                    }
                }
            }
        }
        nodesToRemove.clear();
        edgesToRemove.clear();
        return false;
    }
}
