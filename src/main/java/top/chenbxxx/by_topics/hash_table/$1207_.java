package top.chenbxxx.by_topics.hash_table;

/**
 * 1207. Unique Number of Occurrences
 * Easy
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author chen
 * @date 2019/10/22 上午8:39
 */
public class $1207_ {
    public static void main(String[] args) {
        System.out.println(new $1207_().new Solution().uniqueOccurrences(new int[]{3, 5, -2, -3, -6, -6}));
    }

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {

            // -1000 <= arr[i] <= 1000
            // 第一次遍历映射
            int[] tab = new int[2001];
            for (int i : arr) {
                tab[i + 1000]++;
            }

            // 遍历整个映射数组
            int num = -1;
            for (int i : tab) {
                // 如果i=0,跳过此次循环
                if (i == 0) {
                    continue;
                }
                if (num == i) {
                    return false;
                }
                // 如果num=-1,则先修改num,再跳出此次循环
                if (num == -1) {
                    num = i;
                }

            }
            return true;
        }
    }
}
