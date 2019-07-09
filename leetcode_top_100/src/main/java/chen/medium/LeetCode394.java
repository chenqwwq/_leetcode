package chen.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author chen
 * @description 根据以下字符规则解码:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * @email chenbxxx@gmail.com
 * @date 19-3-6
 */
public class LeetCode394 {
    public static void main(String[] args) {
        System.out.println(new LeetCode394().new Solution().decodeString("3[a]2[bc]"));
    }

    class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            return stackHandle(s);
        }

        /**
         * 以栈为基础结构处理问题，
         * 遍历入栈,遇到]之后逐个出栈直到[
         * <p>
         * AC,但未优化
         */
        private String stackHandle(String s) {
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c.equals(']')) {
                    // 逐个出栈,组合并全部入栈
                    mainHandle(stack);
                    continue;
                }
                stack.push(c);
            }
            StringBuilder res = new StringBuilder();
            while (!stack.empty()) {
                res.append(stack.pop());
            }
            return res.reverse().toString();
        }

        private void mainHandle(Stack<Character> stack) {
            List<Character> list = new ArrayList<>();
            while (!stack.peek().equals('[')) {
                list.add(stack.pop());
            }
            // 翻转,因为结果要翻转
            Collections.reverse(list);
            // 弹出[
            stack.pop();
            // 获取数字
            StringBuilder numStr = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                numStr.append(stack.pop());
            }
            int num = Integer.parseInt(numStr.reverse().toString());
            while (num-- > 0) {
                for (char c : list) {
                    stack.push(c);
                }
            }
        }
    }
}
