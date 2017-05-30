package hackerrank.com.eventree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int numberOfVertices = scan.nextInt();
    	int numberOfEdges = scan.nextInt();
    	
    	Node root = new Node(1, null);
    	List<Node> listOfNodes = new ArrayList<Node>();
    	listOfNodes.add(root);
    	
    	for(int index = 0; index < numberOfEdges; index++){
    		int nextVertice = nextVertice(scan);
    		if (getNodeByValue(listOfNodes, nextVertice) == null)
				listOfNodes.add(new Node(nextVertice, getNodeByValue(listOfNodes, nextEdge(scan)).addCount()));
    	}
    	
    	int teste = 0;
    	for (Node node : listOfNodes) {
			if (node.count % 2 == 0)
				teste++;
		}
    	
    	System.out.println(teste - 1);
    }
    
    private static int nextVertice(Scanner scan){
    	return scan.nextInt();
    }
    
    private static int nextEdge(Scanner scan){
    	return scan.nextInt();
    }
    
    private static Node getNodeByValue(List<Node> nodes, int value){
    	for (Node node : nodes) 
			if (node.value == value)
				return node;
		return null;
    }
    
    private static Node get(Node initial){
    	if ((initial.isLeaf() && initial.isNotVisited()) || (initial.isNotVisited() && initial.allChildrenVisited()))
    		return initial;
    	
    	for (Node child : initial.children) 
    		return get(child);
    	
    	return null;
    }
}

class Node{
	
	List<Node> children = new ArrayList<Node>();
	Node father;
	boolean visited = false;
	int value;
	int count = 1;
	
	public Node(int value, Node father){
		this.value = value;
		this.father = father;
	}
	
	public Node addCount(){
		count++;
		return this;
	}
	
	public int getCount(){
		return count;
	}
	
	public boolean allChildrenVisited() {
		if (isLeaf()) return true;
		
		for (Node node : children) {
			if (node.isNotVisited())
				return false;
		}
		
		return true;//TODO TODO
	}

	public void addChild(Node node){
		children.add(node);
	}
	
	public boolean isNumberOfNodesWithMeEven(){
		return numberOfNodesWithMe() % 2 == 0;
	}
	
	public int numberOfNodesWithMe(){
		int numberOfChildrenWithMe = 1;
		
		if (isLeaf()) return numberOfChildrenWithMe;
		
		for (Node node : children) 
			numberOfChildrenWithMe += node.numberOfNodesWithMe();
		
		return numberOfChildrenWithMe;
	}
	
	public boolean isLeaf(){
		return children.isEmpty();
	}
	
	public boolean isNotVisited(){
		return !visited;
	}
	
	public void setVisited(){
		visited = true;
	}
}