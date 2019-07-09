package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 旋转数组的最小值查找 变种二分法
 * @email ai654778@vip.qq.com
 * @date 19-2-3
 */
public class Offer6 {
    public class Solution {
        public int minNumberInRotateArray(int[] array) {
            int length = array.length, sArr = 0, eArr = length - 1;

            while (eArr > sArr) {
                int midArr = (eArr + sArr) / 2;
                // 用中间元素和首元素对比
                if (array[midArr] < array[sArr]) {
                    // 中间元素小于
                    eArr = midArr;
                } else {
                    sArr = midArr + 1;
                }
            }
            return array[sArr];
        }
    }
}
