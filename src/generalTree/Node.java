package generalTree;

import java.util.LinkedList;

public class Node {
	public String value;
	public LinkedList<Node> child=new LinkedList<>();
	public Node parent;
	public void addNode(Node node) {
		this.child.add(node);
		node.parent=this;
	}
}
