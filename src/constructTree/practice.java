package constructTree;

import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

import binaryTree.*;

public class practice {
	public static void main(String arg[]) {
		new practice().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int num=Integer.parseInt(scanner.nextLine());
		String[] value=new String[num+1];
		for (int i = 0; i < num; i++) {
			value[i]=scanner.nextLine();
		}
		Tree tree=new Tree();
		LinkedList<Node> array=new LinkedList<>();
		array.add(tree.header);
		Node current=new Node();
		for (int i = 0; i < num; i++) {
			String[] values=value[i].split("\\s+");
			for (int j = 0; j < values.length; j++) {
				if (i==0) {
					current=array.getFirst();
					current.value=values[j];
					break;
				}
				Node node=new Node();
				node.value=values[j];
				if ((j+1)%2==1) {
					current.addLNode(node);
					array.add(node);
				}else {
					current.addRNode(node);
					array.add(node);
					current=array.get(array.indexOf(current)+1);
				}
			}
		}
		tree.printTree();
	}
}
