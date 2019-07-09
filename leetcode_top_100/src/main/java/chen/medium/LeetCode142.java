package chen.medium;

/**
 * 142. Linked List Cycle II
 *
 * @author bingxin.chen
 * @date 2019/5/10 14:04
 */
public class LeetCode142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode fast = head, slow = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                // 节点相遇
                if (fast == slow) {
                    while (slow != head) {
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}
