package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 替换字符串的题，可能是针对C++的吧
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 13:13
 */
public class Offer2 {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace(new StringBuffer("We Are Happy")));

    }

    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            return str.toString().replace(" ", "%20");
        }
    }
}
