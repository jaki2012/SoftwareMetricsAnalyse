package ast.graph;

import domain.constants.Layer;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Halstead
 * Package: adt.graph
 * Author:  Novemser
 * 2016/10/18
 */
public class GraphInformation {

    /**
     * Associates the program instructions to the corresponding node in the graph.
     *
     * @param sourceGraph - The graph.
     * @param sourceNode - The node in the graph.
     * @param information - The program information or node information associated to the sourceNode.
     */
    @SuppressWarnings("unchecked")
    public void addInformationToLayer1(Graph<Integer> sourceGraph, Node<Integer> sourceNode, String information) {
        sourceGraph.selectMetadataLayer(Layer.INSTRUCTIONS.getLayer()); // change to instruction layer.
        Map<Node, String> nodeInstructions = (HashMap<Node, String>) sourceGraph.getMetadata(sourceNode); // contains the instructions associated to the node.
        if (nodeInstructions == null) {
            nodeInstructions = new HashMap<>();
            sourceGraph.addMetadata(sourceNode, nodeInstructions);
        }
        Node node = new Node<>(information);
        nodeInstructions.put(node, information);
        sourceGraph.addMetadata(sourceNode, nodeInstructions);
    }

    /**
     * Add guards information to graph edge.
     * This information is stored in abstract graph meta-data Layer.GUARDS.
     *
     * @param sourceGraph - The abstract representation of the graph.
     * @param sourceEdge - The abstract representation of the edge in the abstract graph.
     * @param info - The guards information.
     */
    public void addInformationToLayer2(Graph<Integer> sourceGraph, Edge<Integer> sourceEdge, String info) {
        sourceGraph.selectMetadataLayer(Layer.GUARDS.getLayer()); // change to cycle layer.
        sourceGraph.addMetadata(sourceEdge, info); // add information to edge.
    }
}
