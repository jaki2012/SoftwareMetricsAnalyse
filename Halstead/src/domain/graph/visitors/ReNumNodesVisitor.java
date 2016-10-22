package domain.graph.visitors;

import java.util.HashSet;

import ast.graph.Node;

/**
 * Project: Halstead
 * Package: domain.graph.visitors
 * Author:  Novemser
 * 2016/10/20
 */
public class ReNumNodesVisitor<V extends Comparable<V>> extends DepthFirstGraphVisitor<V> {

	private int nodeNum = 0;

	public ReNumNodesVisitor() {
		visitedNodes = new HashSet<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean visit(Node<V> node) {
		if(!visitedNodes.contains(node)) {
			visitedNodes.add(node);
			node.setValue((V) new Integer(nodeNum));
			nodeNum++;
			return true;
		}
		return false;
	}
}