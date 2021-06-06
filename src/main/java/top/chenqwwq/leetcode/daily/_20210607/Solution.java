package top.chenqwwq.leetcode.daily._20210607;

/**
 * @author chen
 * @date 2021/6/7
 **/
public class Solution {
	int ans = 0;

	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, target, 0);
		return ans;
	}

	public void dfs(int[] nums, int target, int curr) {
		if (curr == nums.length) {
			if (target == 0) {
				ans++;
			}
			return;
		}

		dfs(nums, target - nums[curr], curr + 1);
		dfs(nums, target + nums[curr], curr + 1);
	}
}