package chen.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @description 判断回文链表
 *  全部存入一个数组,翻转后半部分对比
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode234 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	class Solution {
		public boolean isPalindrome(ListNode head) {
			if(head == null || head.next == null){
				return true;
			}
			List<Integer> list = new ArrayList<>();
			while (head != null){
				list.add(head.val);
				head = head.next;
			}

			boolean isEven = list.size() % 2 == 0;
			final int i = list.size() >> 1;
			return isEven ? checkBothSides(list, i - 1, i) : checkBothSides(list, i, i);
		}

		private boolean checkBothSides(List<Integer> list,int left,int right){
			int size = list.size();
			while (left >= 0 && right <= size-1){
				if (!list.get(left--).equals(list.get(right++))) {
					return false;
				}
			}
			return true;
		}
	}
}
