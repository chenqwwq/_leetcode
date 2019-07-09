package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author chen
 * @description 字符串的排列, 穷举试试
 * @email chenbxxx@gmail.com
 * @date 19-2-13
 */
public class Offer27 {
    public static void main(String[] args) {
        System.out.println(new Solution().Permutation("abc"));
    }

    public static class Solution {
        private ArrayList<String> res = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            if (str.length() <= 0) {
                return new ArrayList<>();
            }
            handle(str.toCharArray(), 0);
            return (ArrayList<String>) res.stream().distinct().sorted().collect(Collectors.toList());
        }

        private void handle(char[] src, int length) {
            if (src.length == length) {
                res.add(new String(src));
                return;
            }
            for (int i = length; i < src.length; i++) {
                handle(swapCharArray2Index(src, length, i), length + 1);
                swapCharArray2Index(src, length, i);
            }
        }

        /**
         * 交换char数组两个位置的元素
         *
         * @return 交换完成后的char数组
         */
        private char[] swapCharArray2Index(char[] chars, int index1, int index2) {
            char temp = chars[index1];
            chars[index1] = chars[index2];
            chars[index2] = temp;
            return chars;
        }
    }
}
