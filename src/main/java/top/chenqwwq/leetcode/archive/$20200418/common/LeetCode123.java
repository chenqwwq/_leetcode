package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 123.  买卖股票的最佳时机 III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-21 下午2:32
 */
public class LeetCode123 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;

            // 题目的难点在定死了两次交易,一时间想不出来如何在dp状态方程中体现
            // 最先考虑二维数组,少个状态
            // 三维数组 dp[n][3][2]
            // n -> 表示n天 3 -> 交易次数 2 -> 是否持有股票

            int max = 0;
            int[][][] dp = new int[length][3][2];

            // 初始化第一天的交易
            dp[0][1][1] = -prices[0];
            dp[0][2][1] = -prices[0];

            // 穷举三态
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < 3; j++) {
                    // 当前未持有股票的状态
                    // 交易次数为0
                    if (j == 0) {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], 0);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], 0);
                    } else {
                        // 交易次数不为0
                        // 当前没有持有股票 ==> [前次就没有持有股票,前次持有股票+卖出]
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        // 当前并持有股票 ==> [前次持有股票,前次没有股票-买入]
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
            for (int i = 0; i < prices.length; i++) {
                max = Math.max(max, dp[i][2][0]);
            }
            return max;
        }
    }
}








