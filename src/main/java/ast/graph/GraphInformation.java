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
     * Associates the program instructions to the corresponding node in the abstract grapg.
     * This information is stored in abstract graph meta-data Layer.INSTRUCTIONS.
     *
     * @param sourceGraph - The abstract representation of the graph.
     * @param sourceNode - The abstract representation of the node in the abstract graph.
     * @param instructions - The program instructions or node information associated to the sourceNode.
     */
    @SuppressWarnings("unchecked")
    public void addInformationToLayer1(Graph<Integer> sourceGraph, Node<Integer> sourceNode, String instructions) {
        sourceGraph.selectMetadataLayer(Layer.INSTRUCTIONS.getLayer()); // change to instruction layer.
        Map<Node, String> nodeInstructions = (HashMap<Node, String>) sourceGraph.getMetadata(sourceNode); // contains the instructions associated to the node.
        if (nodeInstructions == null) {
            nodeInstructions = new HashMap<>();
            sourceGraph.addMetadata(sourceNode, nodeInstructions);
        }
        Node node = new Node<>(instructions);
        nodeInstructions.put(node, instructions);
        sourceGraph.addMetadata(sourceNode, nodeInstructions);
    }

    /**
     * Add guards information to abstract graph edge.
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
