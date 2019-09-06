package top.chenbxxx.dynamic_programming;

import java.util.Arrays;

/**
 * 392. Is Subsequence
 * Easy
 * <p>
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 * @author bingxin.chen
 * @date 2019/9/6 12:11
 */
public class LeetCode392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            final int length = t.length(),
                    sLength = s.length();
            final char[] tCha = t.toCharArray(),
                    sCha = s.toCharArray();
            boolean[] dp = new boolean[length];

            // 初始化数组
            for (int i = 0; i < length; i++) {
                if (sCha[0] == tCha[i]) {
                    Arrays.fill(dp, i, t.length(), true);
                    break;
                }
            }
            for (int i = 1; i < sLength; i++) {
                for (int j = i; j < length; j++) {
                    if (sCha[i] == tCha[j] && dp[j - 1]) {
                        Arrays.fill(dp, j, t.length(), true);
                        break;
                    }
                }
            }

            return dp[length - 1];
        }
    }
}
