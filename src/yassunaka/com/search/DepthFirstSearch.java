package yassunaka.com.search;

import java.util.Stack;

public class DepthFirstSearch {
	
	public void execute(Node root){
		Stack<Node> graph = new Stack<>();
		graph.push(root);
		root.setVisited();
		System.out.println(root.value);
		
		while(!graph.isEmpty()){
			Node node = graph.peek();
			Node unvisitedChild = node.getUnvisitedChild();
			
			if (unvisitedChild != null){
				unvisitedChild.setVisited();
				System.out.println(unvisitedChild.value);
				graph.push(unvisitedChild);	
			}
			else
				graph.pop();
		}
		
	}
	
	public static void main(String[] args){
		Node leftLeftNode = new Node(6, null, null);
		Node leftNode = new Node(4, leftLeftNode, null);
		Node rightNode = new Node(5, null, null);
		Node root = new Node(1, leftNode, rightNode);
		
		new DepthFirstSearch().execute(root);
		/*
		  1
		 /\
		4  5 
	  /
	 6 	 
		 */
		
	}
}
