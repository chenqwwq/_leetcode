package chen.medium;

/**
 * 332. Coin Change
 *
 * @author bingxin.chen
 * @date 2019/5/10 12:51
 */
public class LeetCode322 {

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            // 尝试DP解决
            int[] dp = new int[amount + 1];
//            boolean[] pd = new boolean[amount + 1];
            dp[0] = 1;
//            pd[0] = true;

            for (int i = 1; i <= amount; i++) {
                // dp[i] = Math.min(dp[i - coins...])
                dp[i] = getMin(dp, i, coins);
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }

        private int getMin(int[] dp, int i, int[] coins) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                min = Math.min(min, dp[i - coin] + (i - coin > 0 ? 1 : 0));
            }
            return min;
        }
    }
}
