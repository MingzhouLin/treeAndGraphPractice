package PrimAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Graph.Edge;
import Graph.Node;
import Graph.graph;

public class prim {
	public static void main(String[] args) {
		new prim().run();
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		scanner.nextLine();
		graph weightedGraph=new graph();
		for (int i = 0; i < num; i++) {
			String string=scanner.nextLine().trim();
			String[] strings=string.split("\\s+");
			if (!weightedGraph.map.containsKey(strings[0])) {
				Node node=new Node();
				node.value=strings[0];
				Edge edge=new Edge();
				edge.from=node;
				edge.to=node;
				edge.weight=0;
				node.edges.add(edge);
				weightedGraph.map.put(strings[0], node);
			}
			if (!weightedGraph.map.containsKey(strings[1])) {
				Node node=new Node();
				node.value=strings[1];
				Edge edge=new Edge();
				edge.from=node;
				edge.to=node;
				edge.weight=0;
				node.edges.add(edge);
				weightedGraph.map.put(strings[1], node);
			}
			Edge edge=new Edge();
			edge.from=weightedGraph.map.get(strings[0]);
			edge.to=weightedGraph.map.get(strings[1]);
			edge.weight=Integer.parseInt(strings[2]);
			weightedGraph.map.get(strings[0]).edges.add(edge);
		}
//		weightedGraph.printGraph();	
//		shortest path from node F.
		HashMap<String, Integer> distance=new HashMap<>();
		HashMap<String, LinkedList<String>> shortestPath=new HashMap<>();
		LinkedList<String> addedNode=new LinkedList<>();
		int max=100000;
		for (HashMap.Entry<String, Node> entry : weightedGraph.map.entrySet()) {
			distance.put(entry.getKey(),max );
		}
		for (HashMap.Entry<String, Node> entry : weightedGraph.map.entrySet()) {
			LinkedList<String> path=new LinkedList<>();
			path.add(entry.getKey());
			shortestPath.put(entry.getKey(),path );
		}
		String from="F";
		addedNode.add(from);
		while(addedNode.size()<=weightedGraph.map.size()) {
			String node=addedNode.getLast();
			if (node.equals(from)) {
				int min=max;
				String midNode="";
				for (Edge edge : weightedGraph.map.get(node).edges) {
					if (edge.weight<distance.get(edge.to.value)) {
						distance.put(edge.to.value, edge.weight);
					}
				}
				for (HashMap.Entry<String, Integer> entry: distance.entrySet()) {
					if (entry.getValue()<=min&&!addedNode.contains(entry.getKey())) {
						min=entry.getValue();
						midNode=entry.getKey();
					}
				}
				addedNode.add(midNode);
			}else {
				int min=max;
				String midNode="";
				for (Edge edge : weightedGraph.map.get(node).edges) {
					if (edge.weight+distance.get(node)<distance.get(edge.to.value)) {
						distance.put(edge.to.value, edge.weight+distance.get(node));
						shortestPath.get(edge.to.value).add(node);
					}
				}
				for (HashMap.Entry<String, Integer> entry: distance.entrySet()) {
					if (entry.getValue()<=min&&!addedNode.contains(entry.getKey())) {
						min=entry.getValue();
						midNode=entry.getKey();
					}
				}
				addedNode.add(midNode);
			}
		}
		for (HashMap.Entry<String, Integer> entry : distance.entrySet()) {
			System.out.print(entry.getKey()+" "+entry.getValue()+" ");
			System.out.print(shortestPath.get(entry.getKey()).getFirst()+"<-");
			while (shortestPath.get(entry.getKey()).size()>1) {
				System.out.print(shortestPath.get(entry.getKey()).getLast()+"<-");
				shortestPath.get(entry.getKey()).removeLast();
			}
			System.out.println("F");
		}
	}
}
