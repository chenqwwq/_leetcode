package chen.medium;

/**
 * @author CheNbXxx
 * @description 回文子串
 * @email chenbxxx@gmail.con
 * @date 2019/2/27 10:24
 */
public class LeetCode647 {
    public static void main(String[] args) {
        new LeetCode647().new Solution().countSubstrings("aaaaa ");
    }

    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            final int length = s.length();
            boolean[][] dp = new boolean[length][length];
            // 中轴线全为true
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            int count = length;
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (Math.abs(i - j) <= 2 || dp[i - 1][j + 1])) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
            return count;
        }
    }
}
