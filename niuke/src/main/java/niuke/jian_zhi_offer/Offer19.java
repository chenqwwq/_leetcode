package niuke.jian_zhi_offer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author chen
 * @description 顺时针打印二维数组, Leetcode做过, 算是复习吧
 * @email chenbxxx@gmail.com
 * @date 19-2-9
 */
@Slf4j
public class Offer19 {
    public static void main(String[] args) {
//        int[][] i = new int[3][3];
//        int sign = 1;
//        for (int q = 0;q < 3;q++){
//            for (int p = 0;p < 3;p++){
//                i[q][p] = sign++;
//            }
//        }
        int[][] i = new int[5][1];
        i[0][0] = 1;
        i[1][0] = 2;
        i[2][0] = 3;
        i[3][0] = 4;
        i[4][0] = 5;
        log.info(new Solution().printMatrix(i).toString());
    }

    public static class Solution {
        private ArrayList<Integer> list;

        public ArrayList<Integer> printMatrix(int[][] matrix) {
            // 行数目:i
            int i = matrix.length;
            if (matrix.length <= 0) {
                return null;
            }
            // 列数目:j
            int j = matrix[0].length;
            // 初始化返回结果
            list = new ArrayList<>(i * j);
            // 逐层输出
            // 1. 计算中心坐标
            int centerI = i % 2 == 0 ? i / 2 - 1 : i / 2, centerJ = j % 2 == 0 ? j / 2 - 1 : j / 2;
            int minIndex = Math.min(centerI, centerJ);

            for (int x = 0, y = 0; x <= minIndex && y <= minIndex; x++, y++) {
                clockwise(matrix, x, y);
            }
            return list;
        }

        /**
         * 从起始左边开始顺时针开始
         */
        private void clockwise(int[][] matrix, int x, int y) {
            int xLen = matrix.length - 2 * x, yLen = matrix[0].length - 2 * y;
            if (xLen <= 0 || yLen <= 0) {
                return;
            }
            // 下面那个方法好像有点混乱
            // xSign代表x轴坐标,ySign代表y轴坐标
            int xSign = x, ySign = y;
            while (ySign < y + yLen) {
                list.add(matrix[xSign][ySign++]);
            }
            if (xLen == 1) {
                return;
            }
            xSign++;
            ySign--;
            while (xSign < x + xLen) {
                list.add(matrix[xSign++][ySign]);
            }
            if (yLen == 1) {
                return;
            }
            ySign--;
            xSign--;
            while (ySign >= y) {
                list.add(matrix[xSign][ySign--]);
            }
            xSign--;
            ySign++;
            while (xSign > x) {
                list.add(matrix[xSign--][ySign]);
            }
        }

        /**
         * 从起始坐标开始,逆时针遍历
         */
        private void counterclockwise(int[][] matrix, int x, int y) {
            // 计算一行一列各多少长度
            // xLen记录每行多少个
            int xLen = matrix[0].length - 2 * x, yLen = matrix.length - 2 * y;
            // 跟着变化的记录参数
            int xSign = x, ySign = y;
            // 顶边
            while (xSign < x + xLen) {
                list.add(matrix[xSign++][ySign]);
            }
            // 最后会多加一次需要减去
            xSign--;
            // 因为右边的第一个包括在顶边
            ySign++;
            // 右边
            while (ySign < y + yLen) {
                list.add(matrix[xSign][ySign++]);
            }
            ySign--;
            xSign--;
            // 底边
            while (xSign >= x) {
                list.add(matrix[xSign--][ySign]);
            }
            xSign++;
            ySign--;
            // 左边
            while (ySign > y) {
                list.add(matrix[xSign][ySign--]);
            }
        }
    }
}