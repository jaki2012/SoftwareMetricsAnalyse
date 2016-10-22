package ast.graph;

import domain.graph.visitors.IGraphVisitor;

import java.io.Serializable;

public class Node<V extends Comparable<V>> implements Comparable<Node<V>>, Serializable {

	private V value;

	private boolean containsMethodCall;

	private boolean containsParamCall;

	public void containsMethodCall() {
		containsMethodCall = true;
	}

	public boolean isContainMethodCall() {
		return containsMethodCall;
	}

	public boolean isContainsParamCall() {
		return containsParamCall;
	}

	public void containsParamCall() {
		containsParamCall = true;
	}

	public Node(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	public void accept(IGraphVisitor<V> visitor) {
		visitor.visitNode(this);
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public int compareTo(Node<V> o) {
		return value.compareTo(o.value);
	}
}
