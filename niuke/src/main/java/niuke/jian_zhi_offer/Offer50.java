package niuke.jian_zhi_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @description
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer50 {
    public class Solution {
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            if (numbers == null || numbers.length == 0) {
                duplication[0] = -1;
                return false;
            }
            Set<Integer> map = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.contains(numbers[i])) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    map.add(numbers[i]);
                }
            }
            return false;
        }
    }
}
