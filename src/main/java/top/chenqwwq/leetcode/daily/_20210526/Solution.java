package top.chenqwwq.leetcode.daily._20210526;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @author chen
 * @date 2021/5/26
 **/
public class Solution {
	public String reverseParentheses(String s) {
		int left = 0, right = s.length() - 1;
		StringBuilder ans = new StringBuilder();
		StringBuilder ans1 = new StringBuilder();
		boolean flag = false;
		while (left <= right) {
			if (!flag) {
				while (left <= right && s.charAt(left) != '(') {
					ans.append(s.charAt(left++));
				}
				while (right > left && s.charAt(right) != ')') {
					ans1.append(s.charAt(right--));
				}
				flag = true;
			} else {
				while (left <= right && s.charAt(left) != '(') {
					ans1.append(s.charAt(left++));
				}
				while (right > left && s.charAt(right) != ')') {
					ans.append(s.charAt(right--));
				}
				flag = false;
			}
			left++;
			right--;
		}
		return ans.append(ans1.reverse()).toString();
	}
}