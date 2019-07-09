package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 删除排序链表中的重复节点
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null) {
                return pHead;
            }
            // 因为是排序链表所以重复节点是在一块的,直接用双节点
            // 因为重复的节点也不保留,所以要有一些改动
            ListNode pre = pHead, curr = pHead.next, doublePre = null;
            while (curr != null) {
                if (pre.val == curr.val) {
                    // 遍历curr到第一个val不相等的位置
                    while (curr != null && curr.val == pre.val) {
                        curr = curr.next;
                    }
                    // 之前的节点的next值
                    if (doublePre == null) {
                        pHead = curr;
                    } else {
                        doublePre.next = curr;
                    }
                    if (curr == null) {
                        return pHead;
                    }
                    pre = curr;
                    curr = pre.next;
                    continue;
                }
                doublePre = pre;
                pre = pre.next;
                curr = curr.next;
            }
            return pHead;
        }
    }
}
