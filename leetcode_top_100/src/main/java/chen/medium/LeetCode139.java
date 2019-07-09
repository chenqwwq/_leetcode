package chen.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 *
 * @author chen
 * @date 19-5-4
 */
public class LeetCode139 {
    public static void main(String[] args) {
        new LeetCode139().new Solution().wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // DP解决
            final int length;
            if (s == null || (length = s.length()) == 0) {
                return false;
            }
            int maxLength = Integer.MIN_VALUE;
            for (String str : wordDict) {
                maxLength = Math.max(str.length(), maxLength);
            }

            boolean[] dp = new boolean[length + 1];
            dp[0] = true;

            for (int i = 1; i <= length; i++) {
                for (int j = maxLength; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i - j))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[length];
        }
    }
}
