package top.chenqwwq.leetcode.daily._20210719;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/19
 **/
class SolutionTest {

	@Test
	void maxFrequency() {
		Solution solution = new Solution();
		Assertions.assertEquals(3, solution.maxFrequency(new int[]{1, 2, 4}, 5));
	}
}