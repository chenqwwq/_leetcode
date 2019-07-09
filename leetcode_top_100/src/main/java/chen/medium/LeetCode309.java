package chen.medium;

/**
 * 309. 最佳买卖股票时机,含冷冻期
 * https://segmentfault.com/a/1190000014746613
 *
 * @author chen
 * @date 19-4-20
 */
public class LeetCode309 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            final int length = prices.length;

            // 第i天买入股票的最大收益
            int[] buy = new int[length],
                    // 第i天出售股票的最大收益
                    sell = new int[length],
                    // 第i天处于冷冻期的最大收益
                    freezing = new int[length];

            buy[0] = 0 - prices[0];


            for (int i = 1; i < length; i++) {
                sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
                buy[i] = Math.max(freezing[i - 1] - prices[i], buy[i - 1]);
                freezing[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], freezing[i - 1]));
            }
            return sell[length - 1];
        }
    }
}
