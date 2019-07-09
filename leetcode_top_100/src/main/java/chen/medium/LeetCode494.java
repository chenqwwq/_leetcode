package chen.medium;

/**
 * @auther CheNbXxx
 * @description 01背包问题变种，尝试采用DP解决
 * @email chenbxxx@gmail.com
 * @date 2019/3/6 10:13
 */
public class LeetCode494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            return DP(nums, S);
        }

        /**
         * 尝试使用DP解决
         * 01背包问题的变种,求的不是最大值而是特定的值
         * <p>
         * 看了评论：先转化为求特定和的子集的问题
         * sum(P) = (target + sum(nums)) >> 1
         */
        private int DP(int[] nums, int S) {
            if (nums == null) {
                return 0;
            }
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            // 排除异常
            if (sum < S || (S + sum) % 2 > 0) {
                return 0;
            }
            int target = (S + sum) >>> 1;
            // dp中每个元素存储的是和为该值的组合的个数
            int[] dp = new int[target + 1];
            // 0的组合只有一个
            dp[0] = 1;
            for (int n : nums) {
                // 此处必须从S开始，避免被因为当前数字修改的前面数组污染
                for (int i = target; i >= n; i--) {
                    dp[i] += dp[i - n];
                }
            }
            return dp[target];
        }
    }
}
