package hackerrank.com.cutthetree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Map<Integer, Node> nodes = new HashMap<Integer, Node>();  
		
		int numberOfNodes = scan.nextInt();
		int currentNodeValue = 0;
		for(int index = 1; index <= numberOfNodes; index++){
			currentNodeValue = scan.nextInt();
			nodes.put(index, new Node(currentNodeValue));//node value
		}
		
		for(int vertex = 1; vertex < numberOfNodes; vertex++){
			int firstNode = scan.nextInt();
			int secondNode = scan.nextInt();
			nodes.get(firstNode).addAdjacent(nodes.get(secondNode));
			nodes.get(secondNode).addAdjacent(nodes.get(firstNode));
		}
		scan.close();
		
		Node root = nodes.get(1);
		DFS(root);
	}
	
	private static void DFS(Node node){
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		node.visited = true;
		HashSet<Node> hashSetCounted = new HashSet<Node>();
	
		int minimumValue = 99999999;
	
		
		Node child = null;
		while(!stack.isEmpty()){
			node = stack.peek();
			hashSetCounted.add(node);
			child = getUnvisitedAdjacentNode(node);
			
			if (child != null){
				stack.push(child);
				child.visited =true;
				
				HashSet<Node> nodeHash = new HashSet<Node>(Arrays.asList(child));
				HashSet<Node> childHash = new HashSet<Node>(Arrays.asList(node));
				int foundValue = Math.abs(node.getSumOfAdjacentNodesLessThisNode(nodeHash) - child.getSumOfAdjacentNodesLessThisNode(childHash));
				
				if(foundValue < minimumValue)
					minimumValue = foundValue;
			}
			else
				stack.pop();
		}
		
		System.out.println(minimumValue);
	}
	
	private static Node getUnvisitedAdjacentNode(Node node){
		for (Node child : node.adjacents) 
			if (!child.visited)
				return child;
		return null;
	}
}

class Node{
	Set<Node> adjacents = new HashSet<Node>();
	int value;
	boolean visited;
	HashSet<Node> counter = new HashSet<Node>();
	Node(int value){
		this.value = value;
	}
	
	void addAdjacent(Node node){
		adjacents.add(node);
	}
	
	int getSumOfAdjacentNodesLessThisNode(HashSet<Node> counted){
		int sum = value;
		counted.add(this);
		for(Node node: getUncounted(counted)){
			counted.add(node);
			sum += node.getSumOfAdjacentNodesLessThisNode(counted);
		}
			
		return sum;
	}
	
	HashSet<Node> getUncounted(HashSet<Node> counted){
		HashSet<Node> returnHash = new HashSet<Node>();
		for (Node node : adjacents) 
			if (!counted.contains(node))
				returnHash.add(node);
		return returnHash;
	}
}