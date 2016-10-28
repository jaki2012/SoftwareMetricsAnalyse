package domain.graph.structures.rules;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;
import domain.graph.structures.BaseStructure;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * Project: Halstead
 * Package: domain.graph.structures.rules
 * Author:  Novemser
 * 2016/10/22
 */
public class Conditional<V extends Comparable<V>> extends BaseRule<V> {
    public Conditional(String method) {
        super(method);
    }

    @SuppressWarnings("all")
    @Override
    public boolean isStructure(Graph<V> graph, Node<V> node) {
        if (null == node
                || null == graph
                || graph.getNodeEdges(node).size() != 2) {
            return false;
        }
        super.isStructure(graph, node);
        Set<Edge<V>> edges = graph.getNodeEdges(node);
        Node<V> initFirst = ((Edge<V>) edges.toArray()[0]).getEndNode();
        Node<V> initSecond = ((Edge<V>) edges.toArray()[1]).getEndNode();
        if (initFirst.equals(initSecond)) { // redundant path
            edgesToRemove.add((Edge<V>) edges.toArray()[0]);
            return true;
        } else {
            Set<Node<V>> pathFirst = new HashSet<>();
            Set<Node<V>> pathSecond = new HashSet<>();
            Node<V> begin = initFirst;
            Node<V> end = initSecond;

            try {
                while (null != begin
                        && !(boolean) method.invoke(begin)
                        && graph.getNodeEdges(begin).size() == 1) { // no methodName call, only one out-degree
                    if (pathFirst.contains(begin))
                        break;
                    pathFirst.add(begin);
                    begin = ((Edge<V>) graph.getNodeEdges(begin).toArray()[0]).getEndNode();
                }


                if (null != begin && !pathFirst.contains(begin)) { // add last call or non-call node
                    pathFirst.add(begin);
                }

                if (pathFirst.contains(initSecond)) { // second node draws to the left path
                    edgesToRemove.add((Edge<V>) edges.toArray()[1]);
                    return true;
                }

                while (null != end
                        && !(boolean) method.invoke(end)
                        && graph.getNodeEdges(end).size() == 1) { // no methodName call, only one out-degree
                    if (pathSecond.contains(end))
                        break;
                    pathSecond.add(end);
                    end = ((Edge<V>) graph.getNodeEdges(end).toArray()[0]).getEndNode();
                }

                if (null != end && !pathSecond.contains(end)) {
                    pathSecond.add(end);
                }

                if (pathSecond.contains(initFirst)) {
                    edgesToRemove.add((Edge<V>) edges.toArray()[0]);
                    return true;
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
