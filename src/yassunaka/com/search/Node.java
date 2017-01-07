package yassunaka.com.search;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private boolean visited;
	protected List<Node> children;
	protected int value;
	
	public Node(int value, Node... child){
		this.value = value;
		children = new ArrayList<Node>();
		for (Node current : child) 
			children.add(current);
	}
	
    protected Node getUnvisitedChild(){
    	for (Node node : children)
			if (!node.isVisited())
				return node;
    	return null;
    }
    
    protected void setVisited(){
    	visited = true;
    }
    
    protected boolean isVisited(){
    	return visited;
    }
}
