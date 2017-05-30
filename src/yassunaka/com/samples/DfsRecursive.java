package yassunaka.com.samples;

public class DfsRecursive {
	public static void main(String[] args){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		root.addNode(node2)
			.addNode(node3);
		
		node2.addNode(node4)
			 .addNode(node5);
		
		node3.addNode(node6);
		
		dfs(root);
	}
	
	private static void dfs(Node node){
		node.setVisited();
		Node child = null;
		while((child = node.getUnvisitedAdjacent())!= null)
		if (child != null){
			dfs(child);
		}
	}
}