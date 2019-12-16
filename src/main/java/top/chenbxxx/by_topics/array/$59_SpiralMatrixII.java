package top.chenbxxx.by_topics.array;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author bingxin.chen
 * @date 2019/12/16 16:36
 */
public class $59_SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            // 一圈一圈向里面缩进
            final int max = n * n;
            int curr = 0,x = 0,y = 0,level = 0;

            while (curr <= max){
                while (x < n){
                    matrix[x++][y] = ++curr;
                }

                x--;

                while (y < n){
                    matrix[x][y++] = ++curr;
                }

                y--;

                while (x >= 0){
                    matrix[x--][y] = ++curr;
                }

                x++;

                while (y >= 0){
                    matrix[x][y--] = ++curr;
                }

                x = ++level;
                y = level;
            }

            return matrix;
        }
    }
}
