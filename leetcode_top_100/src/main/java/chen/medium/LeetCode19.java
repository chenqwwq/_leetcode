package chen.medium;

/**
 * 19. Remove Nth Node From End of List
 *
 * @author chen
 * @date 19-5-12
 */
public class LeetCode19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 快慢指针
            ListNode fast = head, slow = head;

            // 快指针先走n-1步
            while (n-- > 0) {
                fast = fast.next;
            }
            if (fast == null) {
                head = head.next;
            } else {
                while ((fast = fast.next) != null) {
                    slow = slow.next;
                }
                slow.next = slow.next.next;
            }


            return head;
        }
    }
}
