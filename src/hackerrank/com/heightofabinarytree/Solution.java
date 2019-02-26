package hackerrank.com.heightofabinarytree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	public static int height(Node root) {
		final Stack<Node> graph = new Stack<Node>();
		final List<Integer> visited = new ArrayList<Integer>();
		
		graph.push(root);
		visited.add(root.data);
		int maxHeight = 0;
		int currentHeight = 0;
		
		while(!graph.isEmpty()){
			Node node = graph.peek();
			Node unvisitedChild = unvisitedChild(node, visited);			
			if (unvisitedChild != null){
				visited.add(unvisitedChild.data);
				currentHeight++;
				graph.push(unvisitedChild);	
			}
			else {
				graph.pop();
				if (currentHeight > maxHeight)
					maxHeight = currentHeight;
				
				currentHeight--;
			}
		}	
		
		return maxHeight;
    }
	
	static Node unvisitedChild(Node node, List<Integer> visited) {
		if (node == null)
			return null;
		
		if (node.left != null && !visited.contains(node.left.data))
			return node.left;
		
		if (node.right != null && !visited.contains(node.right.data))
			return node.right;
		
		
		return null;
	}

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}