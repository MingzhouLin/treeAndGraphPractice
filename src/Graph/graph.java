package Graph;

import java.util.HashMap;
import java.util.LinkedList;

public class graph {
	public String value;
	public HashMap<String, Node> map=new HashMap<>();
	public void printGraph() {
		for (HashMap.Entry<String, Node> entry : map.entrySet()) {
			System.out.print(entry.getKey()+": ");
			for (Edge edge : entry.getValue().edges) {
				System.out.print(edge.from.value+" "+edge.to.value+" "+edge.weight+";");
			}
		}
	}
}
