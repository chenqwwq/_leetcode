package niuke.jian_zhi_offer;


/**
 * @author chen
 * @description 合并两个递增链表
 * @email chenbxxx@gmail.com
 * @date 19-2-9
 */
public class Offer16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode Merge(ListNode list1, ListNode list2) {
            // 排除意外情况
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

            // 合并后的列表的头结点
            // 返回值
            ListNode head = null;

            // head的初始值
            if (list1.val <= list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }

            // 临时保存 负责传递链表节点
            ListNode temp = head;
            while (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    temp.next = list2;
                    temp = temp.next;
                    list2 = list2.next;
                } else {
                    temp.next = list1;
                    temp = temp.next;
                    list1 = list1.next;
                }
            }
            if (list1 == null) {
                temp.next = list2;
            } else {
                temp.next = list1;
            }
            return head;
        }
    }
}
