package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 连续子数组的最大和, 第一感觉是DP问题
 * @email chenbxxx@gmail.com
 * @date 19-2-13
 */
public class Offer30 {
    public class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            int[] sumArray = new int[array.length + 1];
            int maxSum = sumArray[0] = array[0];

            for (int i = 1; i < array.length; i++) {
                if (sumArray[i - 1] >= 0) {
                    sumArray[i] = array[i] + sumArray[i - 1];
                } else {
                    sumArray[i] = array[i];
                }
                if (sumArray[i] > maxSum) {
                    maxSum = sumArray[i];
                }
            }
            return maxSum;
        }
    }
}
