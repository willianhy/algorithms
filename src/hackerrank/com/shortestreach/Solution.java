package hackerrank.com.shortestreach;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int numberOfQueries = scan.nextInt();
		Queue<Query> queries = new LinkedList<Query>(); 
		
		for(int query = 0; query < numberOfQueries; query++){
			int numberOfNodes = scan.nextInt();
			int numberOfEdges = scan.nextInt();
			
			Query newQuery = new Query();
			for (int nodeValue = 1; nodeValue <= numberOfNodes; nodeValue ++)
				newQuery.addNode(new Node(nodeValue));
			
			for (int edges = 0; edges < numberOfEdges; edges++) {
				int father = scan.nextInt();
				int child = scan.nextInt();
			
				newQuery.getNodeById(child).setFather(newQuery.getNodeById(father));
			}
			int firstNode = scan.nextInt();
			newQuery.setStartNode(firstNode);
			queries.add(newQuery);
		}
		
		for (Query query : queries)
			calculateShortestPath(query);
	}

	private static void calculateShortestPath(Query query) {
		
		
		Node father = query.getNodeById(query.startNode);
		for (Integer nodeValue : query.hashOfNodes.keySet()) {
			if (nodeValue == query.startNode)
				continue;
			System.out.print(cost(query.getNodeById(nodeValue), father.value, 0) + " ");
		}
		System.out.println("");
		
	}
	
	private static int cost(Node node, int father, int actualCost){
		if (node.father == null) return -1;
		
		if (node.father != null && node.father.value == father)
			return actualCost + 6;
		
		return cost(node.father, father, actualCost + 6);
	}
}
class Query{
	int numberOfNodes;
	int numberOfEdges;
	int startNode;
	Map<Integer, Node> hashOfNodes = new HashMap<Integer, Node>();
	Query(){}
	
	Node getNodeById(int value){
		return hashOfNodes.get(value);
	}
	
	Query setNumberOfNodes(int numberOfNodes){
		this.numberOfNodes = numberOfNodes;
		return this;
	}
	
	Query setNumberOfEdges(int numberOfEdges){
		this.numberOfEdges = numberOfEdges;
		return this;
	}
	
	Query setStartNode(int startNode){
		this.startNode = startNode;
		
		//change the father...
		Node fatherNode = getNodeById(startNode);
		
		if (fatherNode.father == null)
			return this;
		Node nodeThatWillBeChild = fatherNode.father;
		nodeThatWillBeChild.father = fatherNode;
		fatherNode.father = null;
		
		return this;
	}
	
	Query addNode(Node node){
		hashOfNodes.put(node.value, node);
		return this;
	}
}

class Node{
	int value;
	Node father;
	boolean visited;
	
	Node(int value){
		this.value = value;
	}
	
	Node setFather(Node node){
		this.father = node;
		return this;
	}
}
