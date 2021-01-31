package top.chenqwwq.leetcode.week._226._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/1/31
 **/
class SolutionTest {

    Solution solution = new Solution();


    @Test
    void restoreArray() {
        int[] actual = solution.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
        Assertions.assertArrayEquals(new int[]{1,2,3,4}, actual);
    }
}