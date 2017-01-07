package yassunaka.com.search;

import java.util.Stack;

public class DepthFirstSearch {	
	final Stack<Node> graph = new Stack<>();
	private StringBuilder result = new StringBuilder();
	
	public void SetResult(int value){
		result.append(value);
	}
	
	public String GetResult(){
		return result.toString();
	}

	public void execute(Node root){
		graph.push(root);
		root.setVisited();
		SetResult(root.value);
		
		while(!graph.isEmpty()){
			Node node = graph.peek();
			Node unvisitedChild = node.getUnvisitedChild();
			
			if (unvisitedChild != null){
				unvisitedChild.setVisited();
				SetResult(unvisitedChild.value);
				graph.push(unvisitedChild);	
			}
			else
				graph.pop();
		}
		
	}
}
