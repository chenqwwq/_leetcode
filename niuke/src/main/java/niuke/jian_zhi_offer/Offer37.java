package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 数字在排序数组中出现的次数
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 16:02
 */
public class Offer37 {
    public static void main(String[] args) {
        System.out.println(new Offer37().new Solution().GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }

    public class Solution {
        public int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0) {
                return 0;
            }
            return useBinarySearch(array, k);
        }

        private int violence(int[] array, int k) {
            int count = 0;
            for (int i : array) {
                if (i == k) {
                    count++;
                }
            }
            return count;
        }

        private int useBinarySearch(int[] array, int k) {
            int indexWithBinarySearch = getIndexWithBinarySearch(array, k, 0, array.length - 1);
            if (indexWithBinarySearch == -1) {
                return 0;
            }
            int count = 1;
            int i = indexWithBinarySearch;
            while (++i < array.length && array[i] == k) {
                count++;
            }
            while (--indexWithBinarySearch >= 0 && array[indexWithBinarySearch] == k) {
                count++;
            }
            return count;
        }

        private int getIndexWithBinarySearch(int[] array, int k, int start, int end) {
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (array[mid] == k) {
                    return mid;
                } else if (array[mid] > k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
}
