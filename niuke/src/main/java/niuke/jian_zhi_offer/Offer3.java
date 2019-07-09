package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author CheNbXxx
 * @description 链表的遍历和翻转
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 13:27
 */
public class Offer3 {
    public static void main(String[] args) {
        System.out.println(~2);
        System.out.println(6 & ~2);
    }

    public static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if (listNode.next == null) {
                return null;
            }
            ArrayList<Integer> res = new ArrayList<>();
            res.add(listNode.val);
            while (Objects.nonNull(listNode.next)) {
                res.add((listNode = listNode.next).val);
            }
            Collections.reverse(res);
            return res;
        }
    }

    /**
     * public class ListNode {
     * int val;
     * ListNode next = null;
     * <p>
     * ListNode(int val) {
     * this.val = val;
     * }
     * }
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
