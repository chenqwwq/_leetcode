package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 链表中环的入口节点
 * 1. 第一个想法是将路过的节点都存下来,Hash表的形式也行
 * 2. google了一下,因为仅仅只需要找到所以采用 断链法 将遍历过的节点都断开
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead == null || pHead.next == null) {
                return null;
            }
            ListNode pre = pHead, curr = pHead.next;
            // 因为链表有环所以我们遍历的时候不会出现next==null的情况
            // 所以全部断开之后会好判断环入口节点,最后一个next==null的节点就是入口节点
            while (curr != null) {
                pre.next = null;
                pre = curr;
                curr = curr.next;
            }
            return pre;
        }
    }
}
