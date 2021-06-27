package top.chenqwwq.leetcode.daily._20210627;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/6/27
 **/
class SolutionTest {

	@Test
	void snakesAndLadders() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.snakesAndLadders(new int[][]{
				{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}
		}));
		Assertions.assertEquals(4, solution.snakesAndLadders(new int[][]{
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 35, -1, -1, 13, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 15, -1, -1, -1, -1}
		}));
		Assertions.assertEquals(1, solution.snakesAndLadders(new int[][]{
				{-1, -1, -1},
				{-1, 9, 8},
				{-1, 8, 9}
		}));
	}

	@Test
	void change() {
		Solution solution = new Solution();
		solution.cols = 6;
		solution.rows = 6;
		Assertions.assertEquals(12, solution.change(4, 0));
		Assertions.assertEquals(17, solution.change(3, 4));
		Assertions.assertEquals(28, solution.change(1, 3));
	}

	@Test
	void testChange() {
		Solution solution = new Solution();
		solution.cols = 6;
		solution.rows = 6;
		Assertions.assertArrayEquals(new int[]{5, 5}, solution.change(6));
		Assertions.assertArrayEquals(new int[]{0, 0}, solution.change(36));
		Assertions.assertArrayEquals(new int[]{3, 4}, solution.change(17));
		Assertions.assertArrayEquals(new int[]{4, 0}, solution.change(12));
		Assertions.assertArrayEquals(new int[]{1, 3}, solution.change(28));
	}
}