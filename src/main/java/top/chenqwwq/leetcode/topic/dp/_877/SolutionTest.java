package top.chenqwwq.leetcode.topic.dp._877;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/21
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void stoneGame() {
		Assertions.assertTrue(solution.stoneGame(new int[]{5, 3, 4, 5}));
	}
}