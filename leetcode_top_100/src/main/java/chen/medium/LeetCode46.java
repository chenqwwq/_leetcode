package chen.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description  没有重复数字的序列求全排列
 * @email chenbxxx@gmail.con
 * @date 2019/2/26 16:17
 */
public class LeetCode46 {
	class Solution {
		public List<List<Integer>> list = new ArrayList<>();
		public List<List<Integer>> permute(int[] nums) {
			handle(nums,new LinkedList<>(),0);
			return list;
		}

		private void handle(int[] nums,LinkedList<Integer> res,int n){
			if(n == nums.length){
				list.add(res);
				return;
			}
			for (int i = 0;i <= res.size();i++){
				LinkedList<Integer> integers = new LinkedList<>(res);
				integers.add(i,nums[n]);
	            handle(nums,integers,n+1);
            }
		}
	}

	public static void main(String[] args) {
		final List<List<Integer>> permute = new LeetCode46().new Solution().permute(new int[]{1, 2, 3});
		System.out.println(permute);
	}
}
