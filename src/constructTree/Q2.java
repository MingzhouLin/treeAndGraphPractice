package constructTree;

import java.util.LinkedList;
import java.util.Scanner;

import binaryTree.Node;
import binaryTree.Tree;

public class Q2 {
	public static void main(String[] args) {
		new Q2().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		LinkedList<Tree> newTree=new LinkedList<>();
		while (scanner.hasNextLine()) {
			String string =scanner.nextLine().trim();
			if (string.equals("")) {
				break;
			}
			String[] strings=string.split("\\s+");
			if(newTree.isEmpty()) {
				Tree tree1=new Tree();
				tree1.header.value=strings[0];
				Node node=new Node();
				if (!strings[1].equals(".")) {
					node.value=strings[1];
					tree1.header.addLNode(node);
				}
				node=new Node();
				if (!strings[2].equals(".")) {
					node.value=strings[2];
					tree1.header.addRNode(node);
				}
				newTree.add(tree1);
			}else {
				//找头节点
				int num=-1;
				for (int i=0; i < newTree.size(); i++) {
					if (findNode1(strings[0], newTree.get(i).header)!=null) {
						num=i;
						break;
					}
				}
				Tree tree=new Tree();
				tree.header.value=strings[0];
				boolean judge=true;
				for (int i=0; i < newTree.size(); i++) {
					if (newTree.get(i).header.value.equals(strings[1])) {
						if (num!=-1) {
							findNode1(strings[0], newTree.get(num).header).addLNode(newTree.get(i).header);
						}else {
							tree.header.addLNode(newTree.get(i).header);
						}
						newTree.remove(i);
						judge=false;
						break;
					}
				}
				if (judge) {
					Node node=new Node();
					node.value=strings[1];
					if (num!=-1) {
						findNode1(strings[0], newTree.get(num).header).addLNode(node);
					}else {
						tree.header.addLNode(node);
					}
				}
				judge=true;
				for (int i=0; i < newTree.size(); i++) {
					if (newTree.get(i).header.value.equals(strings[2])) {
						if (num!=-1) {
							findNode1(strings[0], newTree.get(num).header).addRNode(newTree.get(i).header);
						}else {
							tree.header.addRNode(newTree.get(i).header);
						}
						newTree.remove(i);
						judge=false;
						break;
					}
				}
				if (judge) {
					Node node=new Node();
					node.value=strings[2];
					if (num!=-1) {
						findNode1(strings[0], newTree.get(num).header).addRNode(node);
					}else {
						tree.header.addRNode(node);
					}
				}
				if (num==-1) {
					newTree.add(tree);
				}
			}
		}
		newTree.getFirst().printTree();
	}
	public Node findNode1(String value, Node header) {
		if (value.equals(header.value)) {
			return header;
		}else {
			if (header.lChild!=null) {
				return findNode1(value, header.lChild);
			}
			if (header.rChild!=null) {
				return findNode1(value, header.rChild);
			}
			return null;
		}
	}
}
