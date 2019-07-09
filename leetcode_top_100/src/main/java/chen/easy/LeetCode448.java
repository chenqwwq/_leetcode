package chen.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description    数组ns中元素大小n ->  1 <= n <= ns.length，找到数组中缺失的数字,时间复杂度为O(n),且不使用别的数组
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 14:32
 */
public class LeetCode448 {
	class Solution {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			// 考虑将i换到nums[i]的位置
			for (int i = 0;i < nums.length;i++){
				// 如果nums[i]不在nums[nums[i]]的位置上就交换过去
				if(nums[nums[i] - 1] != nums[i]) {
					int temp = nums[i];
					nums[i] = nums[nums[i--] - 1];
					nums[temp - 1] = temp;
				}
			}
			// 判断位置上数字错误的
			List<Integer> res = new ArrayList<>();
			for (int i = 0;i < nums.length;i++){
				if(nums[i] != i+1){
					res.add(i+1);
				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
	}
}
