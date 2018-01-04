package Graph;

import java.util.HashMap;

public class adjListGraph {
	public HashMap<Integer, Node> graph=new HashMap<>();
	public void addNode(Integer value,Node node) {
		this.graph.put(value, node);
	}
	public void printGraph() {
		for (HashMap.Entry<Integer, Node> entry : graph.entrySet()) {
			System.out.print(entry.getKey()+":");
			for(Node node: entry.getValue().adjacent) {
				System.out.print(node.value+" ");
			}
			System.out.println();
		}
	}
}
