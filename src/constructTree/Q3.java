package constructTree;

import java.util.ArrayList;
import java.util.Scanner;

import generalTree.Node;
import generalTree.Tree;

public class Q3 {
	public static void main(String[] args) {
		new Q3().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Tree> trees=new ArrayList<>();
		while (scanner.hasNext()) {
			String string=scanner.next();
			String head=string;
			if (string.equals("#")) {
				break;
			}
			int index=0;
			int num=-1;
			while (!string.equals(".")){
				if (index==0) {
					if (trees.isEmpty()) {
						Tree tree=new Tree();
						tree.header.value=string;
						trees.add(tree);
						index++;
						num=0;
					}else {
						for (int i = 0; i < trees.size(); i++) {
							if(fiNode(string, trees.get(i).header)!=null){
								num=i;
							}
						}
						index++;
					}
					if (num==-1) {
						Tree tree=new Tree();
						tree.header.value=string;
						trees.add(tree);
						index++;
						num=trees.indexOf(tree);
						index++;
					}
				}else {
					boolean findNode=false;
					for (int i = 0; i < trees.size(); i++) {
						if (trees.get(i).header.value.equals(string)) {
							fiNode(head, trees.get(num).header).addNode(trees.get(i).header);
							trees.remove(trees.get(i));
							num--;
							findNode=true;
							break;
						}
					}
					if (!findNode) {
						Node node=new Node();
						node.value=string;
						fiNode(head,trees.get(num).header).addNode(node);
					}
				}
				string=scanner.next();
			}
		}
		trees.get(0).printTree();
	}
	public Node fiNode(String value, Node header) {
		if (header.value.equals(value)) {
			return header;
		}else {
			for (Node node : header.child) {
				return fiNode(value, node);
			}
		}
		return null;
	}
}
