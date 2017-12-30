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
			sequence.add(node.lChild);
			sequence.add(node.rChild);
			sequence.removeFirst();
		}
	}
}
