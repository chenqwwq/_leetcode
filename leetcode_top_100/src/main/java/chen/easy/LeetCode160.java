package chen.easy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chen
 * @description 链表相交点的查找
 * 1. 因为相交之后的链表长度一致,所以可以考虑让相交之前的链表先走差的n步
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode160 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 1. 获取两个链表的长度差
            int diff = getListSize(headA) - getListSize(headB);
            if (diff > 0) {
                // A大就A先往下遍历diff个节点
                headA = goNNode(headA, diff);
            } else if (diff < 0) {
                headB = goNNode(headB, -diff);
            }

            // 同时遍历
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }

        private ListNode goNNode(ListNode node, int n) {
            while (n-- > 0) {
                node = node.next;
            }
            return node;
        }

        private int getListSize(ListNode head) {
            int i = 0;
            while (head != null) {
                i++;
                head = head.next;
            }
            return i;
        }
    }
}
