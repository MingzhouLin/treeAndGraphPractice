package PctExample;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Graph.Node;
import Graph.adjListGraph;

public class deadLock {
	public static void main(String[] args) {
		new deadLock().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		scanner.nextLine();
		adjListGraph graph=new adjListGraph();
		for (int i = 0; i < num; i++) {
			String string=scanner.nextLine().trim();
			String[] strings=string.split("\\s+");
			int[] value=new int[3];
			for (int j = 0; j < strings.length; j++) {
				value[j]=Integer.parseInt(strings[j]);
			}
			if (!graph.graph.containsKey(value[0])) {
				Node node=new Node();
				node.value=value[0];
				graph.graph.put(value[0], node);
				if (!graph.graph.containsKey(value[1])) {
					if (value[1]!=-1) {
						node=new Node();
						node.value=value[1];
						node.adjacent.add(graph.graph.get(value[0]));
						graph.graph.put(value[1], node);
					}
				}else {
					graph.graph.get(value[1]).adjacent.add(graph.graph.get(value[0]));
				}
				if (!graph.graph.containsKey(value[2])) {
					if (value[2]!=-1) {
						node=new Node();
						node.value=value[2];
						graph.graph.get(value[0]).adjacent.add(node);
						graph.graph.put(value[2], node);
					}					
				}else {
					graph.graph.get(value[0]).adjacent.add(graph.graph.get(value[2]));
				}
			}else {
				if (!graph.graph.containsKey(value[1])) {
					if (value[1]!=-1) {
						Node node=new Node();
						node.value=value[1];
						node.adjacent.add(graph.graph.get(value[0]));
						graph.graph.put(value[1], node);
					}					
				}else {
					graph.graph.get(value[1]).adjacent.add(graph.graph.get(value[0]));
				}
				if (!graph.graph.containsKey(value[2])) {
					if (value[2]!=-1) {
						Node node=new Node();
						node.value=value[2];
						graph.graph.get(value[0]).adjacent.add(node);
						graph.graph.put(value[2], node);
					}	
				}else {
					graph.graph.get(value[0]).adjacent.add(graph.graph.get(value[2]));
				}
			}
		}
//		graph.printGraph();
		boolean check=false;
		for (HashMap.Entry<Integer, Node> entry : graph.graph.entrySet()) {
			LinkedList<Integer> nodeValue=new LinkedList<>();
			if (Check(entry.getValue(),nodeValue)) {
				System.out.println("YES");
				check=true;
				break;
			}
		}
		if (!check) {
			System.out.println("No");
		}
	}
	public boolean Check(Node node,LinkedList<Integer> nodeValue) {
		if (nodeValue.contains(node.value)) {
			return true;
		}else {
			for (Node node2 : node.adjacent) {
				nodeValue.add(node2.value);
				return Check(node2, nodeValue);
			}
		}
		return false;
	}
}
//5
//101 7 8
//101 9 -1
//102 -1 7
//102 8 -1
//103 -1 9