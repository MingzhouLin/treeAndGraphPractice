package minimumSpanningTree;

import java.util.Scanner;

import Graph.Node;
import Graph.adjListGraph;

public class Q4 {
	public static void main(String[] args) {
		new Q4().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		adjListGraph unweightedGraph=new adjListGraph();
		while (scanner.hasNextLine()) {
			String string =  scanner.nextLine().trim();
			if (string.equals("")) {
				break;
			}
			String[] strings=string.split("\\s+");
			Node head=new Node();
			for (int i = 0; i < strings.length; i++) {
				if (i==0) {
					if (unweightedGraph.graph.containsKey(strings[i])) {
					}else {
						head.value=strings[i];
					}		
				}
				if (head.value.equals("")) {
					Node node=new Node();
					node.value=strings[i];
					unweightedGraph.graph.get(strings[0]).adjacent.add(node);
					if (unweightedGraph.graph.containsKey(strings[i])) {
						if (i!=0) {
							unweightedGraph.graph.get(strings[i]).adjacent.add(unweightedGraph.graph.get(strings[0]));
						}
					}else {
						node.adjacent.add(unweightedGraph.graph.get(strings[0]));
						unweightedGraph.graph.put(strings[i], node);
					}
				}else {
					Node node=new Node();
					node.value=strings[i];
					head.adjacent.add(node);
					if (unweightedGraph.graph.containsKey(strings[i])) {
						if (i!=0) {
							unweightedGraph.graph.get(strings[i]).adjacent.add(head);
						}
					}else {
						node.adjacent.add(head);
						unweightedGraph.graph.put(strings[i], node);
						unweightedGraph.graph.put(head.value, head);
					}
				}
			}
		}
		unweightedGraph.printGraph();
	}
}
