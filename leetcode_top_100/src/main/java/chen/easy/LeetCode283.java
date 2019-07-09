package chen.easy;

/**
 * @author CheNbXxx
 * @description    把数组中的0移动到最后，不改变原来排序
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 14:01
 */
public class LeetCode283 {
	class Solution {
		public void test(int[] nums) {
			if (nums == null || nums.length == 0) {
				return;
			}
			int length = nums.length;
			for (int i = 0; i < length; i++) {
				if (nums[i] == 0) {
					// 移动后面的序列到前面 i+1~length -> i~length-1
					System.arraycopy(nums, i + 1, nums, i, length - i - 1);
					nums[length - 1] = 0;
					length--;
					i--;
				}
			}
		}

		/**
		 * 上面的方法在复制的时候都需要消耗大量的时间，考虑直接复制到第二个数组中
		 */
		public void moveZeroes(int[] nums) {
			int[] res = nums.clone();
			int i = 0;
			for (int temp : res) {
				if (temp != 0) {
					nums[i++] = temp;
				}
			}
			while (i < nums.length){
				nums[i++] = 0;
			}
		}
	}
}
