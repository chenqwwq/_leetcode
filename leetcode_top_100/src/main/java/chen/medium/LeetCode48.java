package chen.medium;

/**
 * @author chen
 * @description 对一个矩形进行旋转
 * @email chenbxxx@gmail.com
 * @date 19-3-4
 */
public class LeetCode48 {
	class Solution {
		public void rotate(int[][] matrix) {
			solvingWay1(matrix);
		}

		private void solvingWay1(int[][] matrix){
			/**
			 * 采用先沿着斜线对折,在上下对折的方法
			 */
			if(matrix == null ){
				return;
			}

			int veriLength = matrix.length;
			int horiLength = matrix[0].length;

			// 1. 沿着斜线对折,沿着正斜线
			for (int i = 0;i < horiLength;i++){
				for(int j = i;j < veriLength;j++){
					swap(matrix,i,j,j,i);
				}
			}

			// 逐行开始,左右对折
			for (int i = 0;i < veriLength;i++){
				for (int y1 = horiLength - 1,y2 = 0;y2 < y1;y1--,y2++){
					swap(matrix,i,y1,i,y2);
				}
			}
		}

		private void swap(int[][] matrix,int x1,int y1,int x2,int y2){
//			matrix[x1][y1] ^= matrix[x2][y2];
//			matrix[x2][y2] ^= matrix[x1][y1];
//			matrix[x1][y1] ^= matrix[x2][y2];
			int temp = matrix[x1][y1];
			matrix[x1][y1] = matrix[x2][y2];
			matrix[x2][y2] = temp;
		}
	}
}
