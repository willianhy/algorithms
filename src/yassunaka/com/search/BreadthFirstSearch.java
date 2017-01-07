package yassunaka.com.search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	Queue<Node> graph = new LinkedList<Node>();
	StringBuilder result = new StringBuilder();
	
	public void setResult(int value){
		result.append(value);
	}
	
	public String getResult(){
		return result.toString();
	}
	
	public void execute(Node root){
		graph.add(root);
		setResult(root.value);
		root.setVisited();
		
		while(!graph.isEmpty()){
			Node node = graph.remove();
			Node child = null;
			
			while((child = node.getUnvisitedChild()) != null){
				child.setVisited();
				setResult(child.value);
				graph.add(child);
			}
		}
	}
}
