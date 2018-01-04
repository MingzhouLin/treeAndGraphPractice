package generalTree;

import java.util.LinkedList;

public class Tree {
	public Node header=new Node();
	public String name;
	public void printTree() {
		LinkedList<Node> array=new LinkedList<>();
		array.add(header);
		while(!array.isEmpty()) {
			System.out.print(array.getFirst().value+" ");
			for (Node node : array.getFirst().child) {
				array.add(node);
			}
			array.removeFirst();
		}
	}
}
