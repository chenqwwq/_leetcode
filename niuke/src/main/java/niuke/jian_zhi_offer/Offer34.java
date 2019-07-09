package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 第一个只出现一次的字符串, 简单的Hash问题
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 10:36
 */
public class Offer34 {
    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("google"));
    }

    public static class Solution {
        public int FirstNotRepeatingChar(String str) {
            if (str.length() == 0) {
                return -1;
            }
            // 值表示出现次数,下标越小表示
            Data[] hash = new Data[256];
            for (int i = 0; i < str.length(); i++) {
                final char c = str.charAt(i);
                if (hash[c] == null) {
                    hash[c] = new Data(i);
                } else {
                    hash[c].count++;
                }
            }
            int minIndex = str.length() + 1;
            for (Data data : hash) {
                if (data != null && data.count == 1) {
                    minIndex = Math.min(minIndex, data.firstIndex);
                }
            }

            return minIndex == (str.length() + 1) ? -1 : minIndex;
        }

        private class Data {
            int firstIndex;
            int count;

            Data(int firstIndex) {
                this.firstIndex = firstIndex;
                count = 1;
            }
        }
    }
}
