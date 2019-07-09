package chen.medium;


import java.util.*;

/**
 * @auther CheNbXxx
 * @description  按照字母给字符串数字分组
 * 1. 预期HashTable解决
 * @email chenbxxx@gmail.com
 * @date 2019/3/6 12:57
 */
public class LeetCode49 {
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			if (strs.length == 0){
				return new ArrayList<>();
			}
			Map<String, List> ans = new HashMap<>(strs.length);
			for (String s : strs) {
				char[] ca = s.toCharArray();
				Arrays.sort(ca);
				String key = String.valueOf(ca);
				if (!ans.containsKey(key)){
					ans.put(key, new ArrayList());
				}
				ans.get(key).add(s);
			}
			return new ArrayList(ans.values());
		}
	}
}
