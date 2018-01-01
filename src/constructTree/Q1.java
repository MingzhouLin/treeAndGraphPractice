package constructTree;

import java.util.Scanner;

import binaryTree.Node;
import binaryTree.Tree;

public class Q1 {
	public static void main(String[] args) {
		new Q1().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		Tree newTree=new Tree();
		while (scanner.hasNextLine()) {
			String string =scanner.nextLine().trim();
			if (string.equals("")) {
				break;
			}
			String[] strings=string.split("\\s+");
			if(newTree.header.value==null) {
				newTree.header.value=strings[0];
				Node node=new Node();
				if (!strings[1].equals(".")) {
					node.value=strings[1];
					newTree.header.addLNode(node);
				}
				node=new Node();
				if (!strings[2].equals(".")) {
					node.value=strings[2];
					newTree.header.addRNode(node);
				}
			}else {
				fiNodeAndAddNode(strings, newTree.header);
			}
		}
		newTree.printTree();
	}
	public void fiNodeAndAddNode(String[] value, Node header) {
		if (value[0].equals(header.value)) {
			Node node=new Node();
			if (!value[1].equals(".")) {
				node.value=value[1];
				header.addLNode(node);
			}
			node=new Node();
			if (!value[2].equals(".")) {
				node.value=value[2];
				header.addRNode(node);
			}
		}else {
			if (header.lChild!=null) {
				fiNodeAndAddNode(value, header.lChild);
			}
			if (header.rChild!=null) {
				fiNodeAndAddNode(value, header.rChild);
			}
		}
	}
}