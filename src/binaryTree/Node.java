package binaryTree;

public class Node {
	public Node lChild=null;
	public Node rChild=null;
	public Node parent;
	public String value;
	public int weight;
	public void addLNode(Node node) {
		lChild=node;
		parent=this;
	}
	public void addRNode(Node node) {
		rChild=node;
		parent=this;
	}
}
