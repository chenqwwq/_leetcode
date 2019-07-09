package chen.easy;

import java.util.Stack;

/**
 * @author chen
 * @description 有效的括号
 * 1. 考虑括号的顺序问题,采用常规的消去
 * 2. 使用栈,出入交错
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode20 {
	class Solution {
		public boolean isValid(String s) {
			if(s == null || s.length() == 0){
				return true;
			}
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray()){
				if(c == '{' || c == '(' || c == '['){
					stack.push(c);
				}else{
					if(stack.isEmpty()){
						return false;
					}
					switch (c){
						case ')':
							if(stack.pop() == '('){
								break;
							}else{
								return false;
							}
						case '}':
							if(stack.pop() == '{'){
								break;
							}else{
								return false;
							}
						case ']':
							if(stack.pop() == '['){
								break;
							}else{
								return false;
							}
						default:
							return false;
					}
				}
			}
			return stack.isEmpty();
		}
	}

	public static void main(String[] args) {
		new LeetCode20().new Solution().isValid("([)]");
	}
}
