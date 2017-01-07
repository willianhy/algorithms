package test.yassunaka.com.search;

import static org.junit.Assert.*;

import org.junit.Test;

import yassunaka.com.search.DepthFirstSearch;
import yassunaka.com.search.Node;

public class TestDepthFirstSearch {

	@Test
	public void HappyDay() {
		Node leftLeftNode = new Node(6);
		Node leftNode = new Node(4, leftLeftNode);
		Node rightNode = new Node(5);
		Node root = new Node(1, leftNode, rightNode);
		
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		depthFirstSearch.execute(root);
		
		assertEquals("should be", "1465", depthFirstSearch.GetResult());
	}

}
