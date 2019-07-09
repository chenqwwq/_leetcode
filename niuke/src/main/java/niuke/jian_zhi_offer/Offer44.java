package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/2/15 15:18
 */
public class Offer44 {
    public class Solution {
        public String ReverseSentence(String str) {
            if (str.trim().equals("")) {
                return str;
            }
            final String[] s = str.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = s.length - 1; i >= 0; i--) {
                stringBuilder.append(s[i]).append(" ");
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
    }
}
