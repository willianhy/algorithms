package yassunaka.com.samples;

import java.util.LinkedList;

class Node{
	private LinkedList<Node> adjacents = new LinkedList<Node>();
	private int value;
	private boolean visited;

	public Node(int value){
		this.value = value;
	}
	
	public Node addNode(Node node){
		adjacents.add(node);
		return this;
	}
	
	public Node setVisited(){
		visited = true;
		System.out.println(value);
		return this;
	}
	
	public Node getUnvisitedAdjacent(){
		for (Node node : adjacents) 
			if (!node.visited)
				return node;
		return null;
	}
	
	public Node getUnvisitedAdjacentAndRemove(){
		for (Node node : adjacents) 
			if (!node.visited){
				adjacents.remove(node);
				return node;
			}
		return null;
	}
}