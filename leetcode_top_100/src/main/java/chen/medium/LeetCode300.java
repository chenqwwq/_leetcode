package chen.medium;

/**
 * 300. Longest Increasing Subsequence
 *
 * @author chen
 * @date 19-4-27
 */
public class LeetCode300 {
    public static void main(String[] args) {
        System.out.println(new LeetCode300().new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max,dp[i]);
            }
            return max;
        }
    }
}
