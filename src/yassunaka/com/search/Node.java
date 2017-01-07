package yassunaka.com.search;

public class Node {
	
	private boolean visited;
	protected Node left;
	protected Node right;
	protected int value;
	
	public Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
		visited = false;
	}
	
    protected Node getUnvisitedChild(){
    	if (left != null && !left.visited)
    		return left;
    	
    	if (right != null && !right.visited)
    		return right;
    	
    	return null;
    }
    
    protected void setVisited(){
    	visited = true;
    }
}
