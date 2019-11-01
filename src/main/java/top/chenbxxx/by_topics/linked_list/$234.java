package top.chenbxxx.by_topics.linked_list;

/**
 * 234. Palindrome Linked List
 * Easy
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @author chen
 * @date 2019/11/1 上午8:11
 */
public class $234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 因为要求O(1)的空间复杂度所有忽略所有另开空间存节点的方法
            // 快慢指针找到中间节点
            ListNode fast = head, slow = head, pre = null, curr = null;

            while (fast.next != null && fast.next.next != null) {
                // 快指针前进两个节点
                fast = fast.next.next;

                // 慢指针前进一个节点,并翻转
                // 考虑在遍历的时候直接翻转
                if (curr != null) {
                    pre = curr;
                }
                curr = slow;
                slow = slow.next;

                if (pre != null) {
                    curr.next = pre;
                    pre = curr;
                    curr = slow;
                }
            }

            if (fast.next != null) {
                // 奇数个节点的情况
                slow = slow.next;
            }

            while (slow.next != null && fast.next != null) {
            }
        }
    }
}
