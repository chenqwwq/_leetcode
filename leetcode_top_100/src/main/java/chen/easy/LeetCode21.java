package chen.easy;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/2/22 11:12
 */
public class LeetCode21 {
	public class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	}
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(Integer.MIN_VALUE),temp = head;

			while (l1 != null && l2 != null){
				if(l1.val > l2.val){
					temp.next = l2;
					temp = temp.next;
					l2 = l2.next;
				}else{
					temp.next = l1;
					temp = temp.next;
					l1 = l1.next;
				}
			}

			temp.next = l1 == null ? l2 : l1;

			return head.next;
		}
	}
}
