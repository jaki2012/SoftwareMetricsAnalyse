package domain.graph.visitors;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/20
 */
public interface IGraphVisitor<V extends Comparable<V>> {
	
	void visitEdge(Edge<V> edge);
	boolean visit(Edge<V> edge);
	void endVisit(Edge<V> edge);
	void visitNode(Node<V> node);
	boolean visit(Node<V> node);
	void endVisit(Node<V> node);
	void visitGraph(Graph<V> graph);
	boolean visit(Graph<V> graph);
	void endVisit(Graph<V> graph);
	boolean alreadyVisited(Node<V> node);
	void handleNode(Node<V> node);
}
