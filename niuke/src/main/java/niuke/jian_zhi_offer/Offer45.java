package niuke.jian_zhi_offer;

import java.util.Arrays;

/**
 * @author chen
 * @description 扑克牌的顺子问题
 * 完全不懂题目什么意思,我还以为要输入字符串,
 * 百度说 0代表大小王 1表示A 等等....
 * 什么弱智题目....
 * @email chenbxxx@gmail.com
 * @date 19-2-16
 */
public class Offer45 {
    public static void main(String[] args) {
        new Offer45().new Solution().isContinuous(new int[]{1, 0, 0, 5, 0});
//		int i = 10;
//		System.out.println(i += 10 - 1);
    }

    public class Solution {
        public boolean isContinuous(int[] numbers) {
            if (numbers == null || numbers.length != 5) {
                return false;
            }
            // 排序
            Arrays.sort(numbers);

            int numOf0 = 0;
            while (numbers[numOf0] == 0) {
                numOf0++;
            }
            // 排除两个王以上的情况
            if (numOf0 > 4) {
                return false;
            }

            int gap = 0;

            for (int i = numOf0 + 1; i < numbers.length; i++) {
                if (numbers[i - 1] == numbers[i]) {
                    return false;
                }
                if (numbers[i - 1] + 1 != numbers[i]) {
                    gap += numbers[i] - numbers[i - 1] - 1;
                }
                numbers[i - 1]++;
            }
            return gap < numOf0;
        }
    }
}
