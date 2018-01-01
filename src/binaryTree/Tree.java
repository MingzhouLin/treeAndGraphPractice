package binaryTree;

import java.util.LinkedList;

public class Tree {
	public Node header=new Node();
	public String name;
	public void printTree() {
		LinkedList<Node> sequence=new LinkedList<>();
		sequence.add(header);
		while(sequence.getFirst()!=null) {
			Node node=sequence.getFirst();
			System.out.print(node.value+" ");
			if (node.lChild!=null) {
				sequence.add(node.lChild);
			}
			if (node.rChild!=null) {
				sequence.add(node.rChild);
			}
			sequence.removeFirst();
			if (sequence.isEmpty()) {
				break;
			}
		}
	}
}
