package chen.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @description    找到字符串中的所有字母异味词
 * 1. 采用hash表和滑动窗口设置
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode438 {
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			if(s == null || p == null || s.length() < p.length()){
				return new ArrayList<>();
			}
			List<Integer> res = new ArrayList<>();
			// 1. 统计Hash数组情况
			int[] hash = new int[26];
			for (char c : p.toCharArray()){
				hash[c - 'a']++;
			}

			int rightIndex=0,leftIndex = 0,count = p.length();
			final char[] sc = s.toCharArray();
			while (rightIndex < s.length()){
				if(--hash[sc[rightIndex++] - 'a'] >= 0) {
					count--;
				}
				if(count == 0){
					res.add(leftIndex);
				}
				if (rightIndex - leftIndex == p.length() && hash[sc[leftIndex++] - 'a']++ >= 0) {
					count++;
				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
		new LeetCode438().new Solution().findAnagrams("cbaebabacd","abc");
	}
}
