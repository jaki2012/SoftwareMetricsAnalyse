package domain.graph.structures.rules;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.BaseStructure;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures.rules
 * Author:  Novemser
 * 2016/10/22
 */
public class Looping<V extends Comparable<V>> extends BaseRule<V> {
    public Looping(String method) {
        super(method);
    }

    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        try {
            if (null == node
                    || graph == null
                    || (boolean) method.invoke(node)
                    || graph.getNodeEdges(node).size() != 1
                    || graph.getNodeEndEdges(node).size() != 2) { // initial loop node condition
                return false;
            }

            super.isStructure(graph, node);
            Set<Edge<V>> edges = graph.getNodeEdges(node);

            Node<V> next = ((Edge<V>) edges.toArray()[0]).getEndNode();

            while (null != next
                    && !(boolean) method.invoke(next)) {
                edges = graph.getNodeEdges(next);

                if (null != edges) {
                    if (edges.size() == 1) {
                        next = ((Edge<V>) edges.toArray()[0]).getEndNode();
                    } else if (edges.size() == 2) {
                        Node<V> first = ((Edge<V>) edges.toArray()[0]).getEndNode();
                        Node<V> second = ((Edge<V>) edges.toArray()[1]).getEndNode();
                        if (first.equals(node)) {
                            edgesToRemove.add((Edge<V>) edges.toArray()[0]);
                            return true;
                        } else if (second.equals(node)) {
                            edgesToRemove.add((Edge<V>) edges.toArray()[1]);
                            return true;
                        }
                    } else {
                        break;
                    }
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }
}
