package leetcode.com.mergetwosortedlists;

public class Solution {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode mergeTwoLists = new Solution().mergeTwoLists(l1, l2);
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode output = null;
    	ListNode first = null;
    	while(l1 != null || l2 != null){
    		if (getVal(l1) <= getVal(l2)){
    			output = set(output, l1);
    			l1 = l1.next;
    			
    		} else {
    			output = set(output, l2);
    			l2 = l2.next;
    		}
    		
    		first = first == null ? output : first;
    	}
    	
        return first;
    }
    
    private int getVal(ListNode node) {
    	return node == null ? Integer.MAX_VALUE : node.val;
    }
    
    private ListNode set(ListNode current, ListNode newNode){
    	if (current == null)
			return newNode;
    	
    	current.next = newNode;
    	return newNode;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}