package chen.easy;

/**
 * @author CheNbXxx
 * @description     整数数字的汉明距离,二进制位中不一样的个数
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 10:51
 */
public class LeetCode461 {
	class Solution {
		public int hammingDistance(int x, int y) {
			// 先异或将不同的位置1
			int i = x ^ y;
			// 统计i中1的个数
			int count = 0;
			while (i != 0){
				count++;
				// 能够消去最后一位1
				i &= (i-1);
			}
			return count;
		}
	}
}
