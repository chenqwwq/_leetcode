package top.chenqwwq.leetcode.week._243._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/30
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void maxValue() {

		Assertions.assertEquals("4699757879438632651173569913153377", solution.maxValue("469975787943862651173569913153377", 3));
		Assertions.assertEquals("-4451", solution.maxValue("-451", 4));
		Assertions.assertEquals("-5648468153646", solution.maxValue("-648468153646", 5));
		Assertions.assertEquals("-12301", solution.maxValue("-2301", 1));
		Assertions.assertEquals("-123", solution.maxValue("-23", 1));
		Assertions.assertEquals("763", solution.maxValue("73", 6));
		Assertions.assertEquals("412365", solution.maxValue("12365", 4));
		Assertions.assertEquals("-123465", solution.maxValue("-12365", 4));
		Assertions.assertEquals("-1255", solution.maxValue("-155", 2));
		Assertions.assertEquals("-1323", solution.maxValue("-132", 3));
	}
}