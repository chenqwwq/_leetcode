package chen.medium;

/**
 * 148. Sort List
 *
 * @author bingxin.chen
 * @date 2019/4/28 13:04
 */
public class LeetCode148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            // 因为要求nlogn的时间复杂度,以及1的空间复杂度
            // 所以考虑归并排序
            if (head == null || head.next == null) {
                return head;
            }

            // 使用快慢指针遍历到中间节点
            // 注意需要确定到中点slow时,断开slow的前面的next
            ListNode slow = head, fast = head, pre = slow;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;

            return merge(sortList(head), sortList(slow));
        }

        private ListNode merge(ListNode right, ListNode left) {

            ListNode head = new ListNode(0), curr = head;
            while (right != null && left != null) {
                if (right.val < left.val) {
                    curr.next = right;
                    right = right.next;
                } else {
                    curr.next = left;
                    left = left.next;
                }
                curr = curr.next;
            }

            while (left != null) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }

            while (right != null) {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
            return head.next;
        }
    }
}
