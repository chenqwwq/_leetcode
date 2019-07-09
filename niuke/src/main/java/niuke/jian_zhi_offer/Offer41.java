package niuke.jian_zhi_offer;

import java.util.ArrayList;

/**
 * @author CheNbXxx
 * @description 和为sum的连续正数序列
 * 连续的正数序列，考虑用滑动窗口机制
 * @email chenbxxx@gmail.con
 * @date 2019/2/15 14:04
 */
public class Offer41 {
    public static void main(String[] args) {
        new Offer41().new Solution().FindContinuousSequence(3);
    }

    public class Solution {
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            int left = 1, right = 2, max = (sum + 1) >> 1, currSum = 3;
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            while (left < right || max > right) {
                if (currSum == sum) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        temp.add(i);
                    }
                    res.add(temp);
                }

                // 右边继续向右滑动
                right++;
                currSum += right;

                // 如果大于则左边向右滑动
                while (currSum > sum) {
                    currSum -= left++;
                }
            }
            return res;
        }
    }
}
