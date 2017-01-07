package test.yassunaka.com.search;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import yassunaka.com.search.BreadthFirstSearch;
import yassunaka.com.search.Node;

public class TestBreadthFirstSearch {

	@Test
	public void happyDay() {
		Node leftLeftNode = new Node(6);
		Node leftNode = new Node(4, leftLeftNode);
		Node rightNode = new Node(5);
		Node root = new Node(1, leftNode, rightNode);
		
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		breadthFirstSearch.execute(root);
		
		assertEquals("should be", "1456", breadthFirstSearch.getResult());
	}

}
