package niuke.jian_zhi_offer;

import java.util.ArrayList;

/**
 * @author chen
 * @description 求链表的倒数第K个元素
 * 1. 转化为数组再找
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        final ArrayList<ListNode> integers = conversionToArray(head);
        final int size = integers.size();
        if (size >= k) {
            return integers.get(size - k);
        }
        return null;
    }

    public ArrayList<ListNode> conversionToArray(ListNode head) {
        ArrayList list = new ArrayList();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
