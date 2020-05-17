package top.chenqwwq.leetcode.daily._20200516;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.ListNode;
import top.chenqwwq.leetcode.utils.ListUtils;

/**
 * @author chen
 * @date 2020/5/16 下午3:53
 */
class SolutionTest {

    private ListNode input;

    private Solution solution;


    {
        solution = new Solution();

        input = new ListNode(1);
        ListNode l2 = new ListNode(2);
        input.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        final ListNode l5 = new ListNode(5);
        l4.next = l5;
        l5.next = new ListNode(6);
    }

    @Test
    void reverseKGroup() {
        final ListNode list = solution.reverseKGroup(input, 3);
        Assertions.assertTrue(ListUtils.compareLinkedList(list, new int[]{2, 1, 4, 3, 5}));
        Assertions.assertTrue(ListUtils.compareLinkedList(solution.reverseKGroup(input, 3), new int[]{3, 2, 1, 4, 5}));
    }
}