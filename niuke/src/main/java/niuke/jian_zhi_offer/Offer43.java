package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 左玄幻字符串
 * @email chenbxxx@gmail.con
 * @date 2019/2/15 14:57
 */
public class Offer43 {
    public static void main(String[] args) {
        System.out.println(new Offer43().new Solution().LeftRotateString("abcdefg", 2));
    }

    public class Solution {
        public String LeftRotateString(String str, int n) {
            if (str.length() < n) {
                return "";
            }
            return str.substring(n) + str.substring(0, n);
        }
    }
}
