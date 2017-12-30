package minimumSpanningTree;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Graph.Node;
import Graph.adjListGraph;
import Graph.matrix;

public class constructTree {
	public static void main(String arg[]) {
		new constructTree().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		matrix weight=new matrix();
		for (int i = 0; i < weight.matrix.length; i++) {
			for (int j = 0; j < weight.matrix[i].length; j++) {
				weight.matrix[i][j]=scanner.nextInt();
			}
		}
		adjListGraph minimum=new adjListGraph();
		Node node=new Node();
		node.value=0;
		minimum.addNode(0, node);
		int index=-1;
		int key=0;
		while (minimum.graph.size()<weight.matrix.length) {
			int minimumWeight=100000;
			for(HashMap.Entry<Integer, Node> entry: minimum.graph.entrySet()) {
				for (int i = 0; i < weight.matrix[entry.getKey()].length; i++) {
					if (weight.matrix[entry.getKey()][i]<minimumWeight && !minimum.graph.containsKey(i)) {
						minimumWeight=weight.matrix[entry.getKey()][i];
						key=entry.getKey();
						index=i;
					}
				}
			}
			node=new Node();
			node.value=index;
			node.adjacent.add(minimum.graph.get(key));
			minimum.graph.put(index, node);
			minimum.graph.get(key).adjacent.add(node);
		}
		minimum.printGraph();
	}
}
