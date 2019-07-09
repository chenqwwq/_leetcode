package chen.easy;

/**
 * @author chen
 * @description 判断一个链表有没有环
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode141 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public class Solution {
		public boolean hasCycle(ListNode head) {
			if(head == null || head.next == null){
				return false;
			}
			ListNode slow = head,fast = slow.next;

			while (slow != fast){
				// 如果无环,肯定是快指针先到链表底
				if(fast == null || fast.next == null){
					return false;
				}

				slow = slow.next;
				fast = fast.next.next;
			}

			return true;
		}
	}
}
