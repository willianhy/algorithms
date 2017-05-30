package yassunaka.com.distancetwonodesbinarytree;

public class Solution {
	public static void main(String[] args){
		Node root = new Node(4);
		addNode(root, new Node(2));
		addNode(root, new Node(3));
		addNode(root, new Node(5));
		addNode(root, new Node(6));
		addNode(root, new Node(1));
		
		int costOfPath = findCostOfPath(root, 1, 3);
		System.out.println(costOfPath);
	}
	
	private static int findCostOfPath(Node root, int i, int j) {
		Node findLCA = findLCA(root, i, j);
		
		int firstFromRoot = findCostFromRoot(findLCA, i);
		int secondFromRoot = findCostFromRoot(findLCA, j);
		
		return firstFromRoot + secondFromRoot;
	}
	
	public static Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
		if (root.data == n1 || root.data == n2) {
		return root;
					}
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);
		if (left != null && right != null) {
		return root;
					}
		if (left != null) {
		return left;
					}
		if (right != null) {
		return right;
					}
				}
		return null;
			}

	private static int findCostFromRoot(Node root, int value){
		if (root.data == value) return 0;
		
		if (root.data > value)
			return findCostFromRoot(root.left, value) + 1;
		
		return findCostFromRoot(root.right, value) + 1;
	}

	private static void addNode(Node root, Node newNode){
		if (newNode == null) return;
		
		if (root.data > newNode.data){
			if (root.left == null)
				root.left = newNode;
			else
				addNode(root.left, newNode);
		}else if(root.data < newNode.data){
			if (root.right == null)
				root.right = newNode;
			else
				addNode(root.right, newNode);
		}
	}
}

class Node{
	Node left = null, right = null;
	int data;
	Node(int data){
		this.data = data;
	}
}