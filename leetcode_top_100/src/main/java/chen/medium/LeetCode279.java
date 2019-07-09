package chen.medium;

/**
 * 279. 完全平方数
 * DP解决,不过效率不高
 *
 * @author bingxin.chen
 * @date 2019/4/24 12:47
 */
public class LeetCode279 {

    class Solution {
        public int numSquares(int n) {
            // dp解决
            if (n <= 3) {
                return n;
            }

            // dp[n]保存n的完全平方数个数和
            // dp[4] = 1; 4 => 2 * 2
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;

            for (int i = 4; i <= n; i++) {
                dp[i] = i;
                // 遍历小于i的最大完全平方数 m
                for (int j = 1; (i - j * j) >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
