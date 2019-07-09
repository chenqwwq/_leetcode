package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 数组中的逆序对，往上题解说归并排序类似,先写了一遍归并排序
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 13:44
 */
public class Offer35 {
    public static class Solution {
        private int count = 0;

        public int InversePairs(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            dispersion(array, 0, array.length - 1, new int[array.length]);
            return count;
        }

        private void dispersion(int[] array, int start, int end, int[] temp) {
            if (start < end) {
                int mid = (start + end) >> 1;
                dispersion(array, start, mid, temp);
                dispersion(array, mid + 1, end, temp);
                countMain(array, start, mid, end, temp);
            }
        }

        private void countMain(int[] array, int start, int mid, int end, int[] temp) {
            int left = start, right = mid + 1, i = 0;
            while (left <= mid && right <= end) {
                if (array[left] > array[right]) {
                    temp[i++] = array[right++];
                    count += mid - left + 1;
                } else {
                    temp[i++] = array[left++];
                }
            }

            // 剩余的部分填充到temp
            while (left <= mid) {
                temp[i++] = array[left++];
            }
            while (right <= end) {
                temp[i++] = array[right++];
            }
            // 复制到原数组
            i = 0;
            while (start <= end) {
                array[start++] = temp[i++];
            }
        }
    }
}
