package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 两个链表的第一个公共节点
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 15:37
 */
public class Offer36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {

        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            // 计算差让较长的链表先走出差的长度
            ListNode node1 = pHead1, node2 = pHead2;
            int len1 = 0, len2 = 0;
            while (node1 != null) {
                len1++;
                node1 = node1.next;
            }
            while (node2 != null) {
                len2++;
                node2 = node2.next;
            }
            if (len1 > len2) {
                while (len1-- > len2) {
                    pHead1 = pHead1.next;
                }
            } else if (len1 < len2) {
                while (len2-- > len1) {
                    pHead2 = pHead2.next;
                }
            }

            // 逐步比较
            while (pHead1 != null && pHead2 != null) {
                if (pHead1 == pHead2) {
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return null;
        }
    }
}
