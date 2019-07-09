package chen.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @description
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode997 {
	class Solution {
		public int findJudge(int N, int[][] trust) {
			if(trust == null || N == 0){
				return -1;
			}
            int[] rightPeople = new int[N];
			int[] trustNum = new int[N];
			for(int[] i : trust){
				rightPeople[i[0]-1] = 1;
				trustNum[i[1]-1]++;
			}

			List<Integer> list = new ArrayList<>();
			for (int i = 0;i < N;i++){
				if(rightPeople[i] == 0 && trustNum[i] == N-1){
					list.add(i+1);
				}
			}
			return list.size() == 1 ? list.get(0) : -1;
		}
	}

	public static void main(String[] args) {
		int[] i = new int[]{1,2};
		int[][] k = new int[1][2];
		k[0] = i;

		new LeetCode997().new Solution().findJudge(2,k);
	}
}
