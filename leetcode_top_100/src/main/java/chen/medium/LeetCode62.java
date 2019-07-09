package chen.medium;

/**
 * @author chen
 * @description  不同路径,只有右边和下边可以走
 * @email chenbxxx@gmail.com
 * @date 19-3-4
 */
public class LeetCode62 {
	class Solution {
		public int uniquePaths(int m, int n) {
			return solution1(m,n);
		}
		/**
		 * 二位数组的动态规划
		 * 0ms,100%
		 */
		private int solution1(int m,int n){
			int[][] dp = new int[m][n];
			for(int i = 0;i < n;i++){
				dp[0][i] = 1;
			}
			for(int i = 0;i < m;i++){
				dp[i][0] = 1;
			}
			// dp数组的第一行第一列默认为0
			for (int i = 1;i < m;i++){
				for (int j = 1;j < n;j++){
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			return dp[m-1][n-1];
		}
	}
}
