package chen.easy;

/**
 * @author CheNbXxx
 * @description   找到数组里面只出现了一次的数字，其他为两个
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 11:40
 */
public class LeetCode136 {
	class Solution {
		public int singleNumber(int[] nums) {
			if(nums == null || nums.length == 0){
				return 0;
			}
			if(nums.length == 1){
				return nums[0];
			}
			int i = nums[0];
			for (int q = 1;q < nums.length;q++){
				i ^= nums[q];
			}
			return i;
		}
	}

	public static void main(String[] args) {
		new LeetCode136().new Solution().singleNumber(new int[]{2,2,1});
	}
}
