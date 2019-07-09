package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 链表翻转 此处跳过第一种使用数组作为中间保存的方式
 * 1. 使用三个节点循环迭代
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer15 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode n1 = head, n2 = head.next;
            while (n2 != null) {
                ListNode temp = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = temp;
            }
            // 这一步相关党建！！！
            head.next = null;
            return n1;
        }
    }
}
