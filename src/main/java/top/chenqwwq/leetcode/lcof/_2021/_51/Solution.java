package top.chenqwwq.leetcode.lcof._2021._51;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 *
 * @author chen
 * @date 2021-05-27
 **/
public class Solution {
	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	public int mergeSort(int[] nums, int left, int right) {
		if (left >= right) {
			return 0;
		}

		int mid = (left + right) >> 1;
		int ans = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

		// 合并


	}
}