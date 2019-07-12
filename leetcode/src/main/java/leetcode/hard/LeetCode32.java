package leetcode.hard;

import java.util.Stack;

/**
 *
 * 32. Longest Valid Parentheses
 * Hard
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"* Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * 第一眼看到以为是堆栈,但是提示说是DP.
 * 完全想不到公式,用暴力写一遍试试
 *
 * 刚动手写,突然发现说的是子串
 *
 * @author bingxin.chen
 * @date 2019/7/12 13:20
 */
public class LeetCode32 {
    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            final char[] chars = s.toCharArray();
            Stack<Character> brackets = new Stack<>();

            int max = 0;
        }
    }
}
