package niuke.jian_zhi_offer;

import java.util.ArrayList;

/**
 * @author CheNbXxx
 * @description 递增序列中找两个数和为n
 * 1、 尝试滑动窗口
 * @email chenbxxx@gmail.con
 * @date 2019/2/15 14:30
 */
public class Offer42 {
    public static void main(String[] args) {
        new Offer42().new Solution().FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 16}, 17);
    }

    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            if (array == null || array.length < 2) {
                return new ArrayList<>();
            }
            int left = 0, right = array.length - 1,
                    currSum = array[left] + array[right],
                    product = currSum == sum ? array[left] * array[right] : Integer.MAX_VALUE;
            ArrayList<Integer> res = new ArrayList<>(2);

            while (left < right) {
                if (sum == currSum) {
                    if (array[left] * array[right] <= product) {
                        res.clear();
                        res.add(array[left]);
                        res.add(array[right]);
                    }
                }
                // 和较小时左边窗口右移
                if (sum < currSum) {
                    currSum = currSum - array[right--] + array[right];
                } else {
                    currSum = currSum - array[left++] + array[left];
                }
            }
            return res;
        }
    }
}
