package chen.medium;

/**
 * @auther CheNbXxx
 * @description 1~n的数字构建二叉搜索树
 * 1. 规律性问题，在评论里面看到规律了 就简单了
 * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 * G(0) = 1
 * G(1) = 1
 * G(2) = G(0)*G(1)+ G(1)*G(0)
 * G(3) = G(0)*G(2) + G(1)*G(1)+ G(2)*G(0) = 1 + 1 + 2
 * @email chenbxxx@gmail.com
 * @date 2019/3/6 09:38
 */
public class LeetCode96 {
	class Solution {
		/**
		 * 一维数组的DP
		 */
		public int numTrees(int n) {
			if(n <= 1){
				return 1;
			}
			int[] dp = new int[n+1];
			dp[0] = dp[1] = 1;
			for (int i = 2;i <= n;i++){
				int res = 0;
				for (int j = 0;j < i;j++){
					res += dp[j] * dp[i - j - 1];
				}
				dp[i] = res;
			}
			return dp[n];
		}
	}
}
