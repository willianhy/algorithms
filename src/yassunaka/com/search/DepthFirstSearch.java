package yassunaka.com.search;

import java.util.Stack;

public class DepthFirstSearch {	
	final Stack<Node> graph = new Stack<Node>();
	private StringBuilder result = new StringBuilder();
	
	public void setResult(int value){
		result.append(value);
	}
	
	public String getResult(){
		return result.toString();
	}

	public void execute(Node root){
		graph.push(root);
		root.setVisited();
		setResult(root.value);
		
		while(!graph.isEmpty()){
			Node node = graph.peek();
			Node unvisitedChild = node.getUnvisitedChild();
			
			if (unvisitedChild != null){
				unvisitedChild.setVisited();
				setResult(unvisitedChild.value);
				graph.push(unvisitedChild);	
			}
			else
				graph.pop();
		}
		
	}
}
