package top.chenqwwq.leetcode.week._214._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2020/11/8
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void getMaximumGenerated() {

        Assertions.assertEquals(3, solution.getMaximumGenerated(7));
        Assertions.assertEquals(1, solution.getMaximumGenerated(2));
        Assertions.assertEquals(2, solution.getMaximumGenerated(3));
    }
}