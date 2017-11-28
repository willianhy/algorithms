package leetcode.com.addtwonumbers;

public class Solution {
	public static void main(String args[]) {
		ListNode listNode13 = new ListNode(3);
		
		ListNode listNode12 = new ListNode(4);
		listNode12.next = listNode13;
		
		ListNode listNode11 = new ListNode(2);
		listNode11.next = listNode12;
		
		
		ListNode listNode23 = new ListNode(4);
		
		ListNode listNode22 = new ListNode(6);
		listNode22.next = listNode23;
		
		ListNode listNode21 = new ListNode(5);
		listNode21.next = listNode22;
		
		new Solution().addTwoNumbers(listNode11, listNode21);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current = null;
		ListNode firstNode = null;
		int remainder = 0;
		int quotient = 0;
		while(true){
			int sum = nextValue(l1) + nextValue(l2) + quotient;
			quotient = sum / 10;
			remainder = sum % 10;
			
			current = addNewNode(current, remainder);
			firstNode = firstNode == null ? current : firstNode;
			
			l1 = nextListNode(l1);
			l2 = nextListNode(l2);
			
			if (l1 == null && l2 == null){
				if (quotient > 0)
					addNewNode(current, quotient);
				break;
			}
		}
		
		return firstNode;
	}
	
	private ListNode addNewNode(ListNode current, int value){
		if (current == null)
			current = new ListNode(value);
		else{
			current.next = new ListNode(value);
			current = current.next;
		}
		
		return current;
	}
	
	private ListNode nextListNode(ListNode listNode){
		return listNode == null ? null : listNode.next;
	}
	
	private int nextValue(ListNode listNode){
		return listNode == null ? 0 : listNode.val;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}