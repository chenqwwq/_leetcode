package chen.easy;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 14:58
 */
public class LeetCode206 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	class Solution {
		public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
            	return head;
            }
            ListNode node1 = head,node2 = head.next;

            while (node2 != null){
            	ListNode temp = node2.next;
            	node2.next = node1;
            	node1 = node2;
            	node2 = temp;
            }

            head.next = null;
            return node1;
		}
	}
}
