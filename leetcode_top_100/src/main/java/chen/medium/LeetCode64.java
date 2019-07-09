package chen.medium;

/**
 * The type Leet code 64.
 *
 * @auther CheNbXxx
 * @description 找到二维数组中左上到右下的最小权值路径, 二维数组的DP问题
 * @email chenbxxx @gmail.com
 * @date 2019 /3/5 16:02
 */
public class LeetCode64 {
	class Solution {
		public int minPathSum(int[][] grid) {
			if(grid == null){
				return 0;
			}
			int veriLen = grid.length,horiLen = grid[0].length;
			int[][] dp = new int[veriLen][horiLen];
			// 初始化首行首列
			int sum = 0;
			for(int i = 0;i < veriLen;i++){
				dp[i][0] = sum += grid[i][0];
			}
			sum = grid[0][0];
			for (int i = 1;i < horiLen;i++){
				dp[0][i] = sum += grid[0][i];
			}
			// 规划
			for (int i = 1;i < veriLen;i++){
				for (int j = 1;j < horiLen;j++){
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
				}
			}

			return dp[veriLen-1][horiLen-1];
		}
	}
}
