package chen.medium;

/**
 * @author CheNbXxx
 * @description     比特位计数,看到原来有动态规划的标记，考虑如何将n与之前的0~n-1联系起来
 * @email chenbxxx@gmail.con
 * @date 2019/2/26 12:37
 */
public class LeetCode338 {
	class Solution {
		public int[] countBits(int num) {
			int[] i = new int[num + 1];
			for (int q = 1; q < num; q++) {
				// q & (q - 1) ==> 从左往右第一个1的位置
				i[q] = i[q & (q - 1)] + 1;
			}
			return i;
		}
	}

	public static void main(String[] args) {
		new LeetCode338().new Solution().countBits(2);
	}
}
