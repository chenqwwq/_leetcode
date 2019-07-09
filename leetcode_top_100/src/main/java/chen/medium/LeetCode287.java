package chen.medium;

/**
 * @author chen
 * @description 寻找数组中重复的数字
 * @email chenbxxx@gmail.com
 * @date 19-3-2
 */
public class LeetCode287 {
	class Solution {
		/**
		 * 因为0~n的数组里存的0~n的数字,
		 * 所以只需要将对应的数字交换到对应的位置,
		 * 如果位置上已经存在该数字表示数字重复
		 *
		 * !!! 此题假设只有一个重复数字
		 * nums[0] = 1;
		 */
		public int findDuplicate(int[] nums) {
			for (int i = 0;i < nums.length;){
				if(nums[i] != i+1){
					if(nums[nums[i] - 1] == nums[i]){
						return nums[i];
					}
					int temp = nums[i];
					nums[i] = nums[temp - 1];
					nums[temp - 1] = temp;
					continue;
				}
				i++;
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		new LeetCode287().new Solution().findDuplicate(new int[]{1,3,4,2,2});
	}
}
