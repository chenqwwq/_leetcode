package chen.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description 求一个不包含重复元素的数组的全部子集
 * 1. 回溯+DFS
 * @email chenbxxx@gmail.con
 * @date 2019/2/28 9:47
 */
public class LeetCode78 {
	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			return bitWat(nums);
		}

		/**
		 * 位运算版本
         * 因为是不包含重复的集合,所以可以采用位运算来处理
         * eg. [1,2,3](001) -> [3]
         */
		public List<List<Integer>> bitWat(int[] num){
			if(num == null || num.length == 0){
				return new ArrayList<>();
			}
			List<List<Integer>> res = new ArrayList<>();
			int min = 0,max = (int) Math.pow(2,num.length);
			for(int i = min;i < max;i++){
				List<Integer> temp = new ArrayList<>();
				for (int j = 0;j < num.length;j++){
					if(getBitAndEquals(i,j)){
						temp.add(num[j]);
					}
				}
				res.add(temp);
			}
			return res;
		}

		/**
		 * 取num的右往左第i位
		 */
		public boolean getBitAndEquals(int num,int i){
			return (num >> i & 1) == 1;
		}

		/**
		 * DFS深度优先搜索遍历版本
		 */
		public List<List<Integer>> dfsWay(int[] nums){
			List<List<Integer>> res = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			dfs(res, temp, nums, 0);
			return res;
		}
		private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
			res.add(new ArrayList<>(temp));
			for(int i = j; i < nums.length; i++) {
				temp.add(nums[i]);
				dfs(res, temp, nums, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		new LeetCode78().new Solution().subsets(new int[]{1,2,3});
	}
}
