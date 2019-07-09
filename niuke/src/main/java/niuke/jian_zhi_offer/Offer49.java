package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer49 {
    public static void main(String[] args) {
//		System.out.println(new Offer49().new Solution().StrToInt("-2147483648"));
        System.out.println((int) (147483648 + 2 * Math.pow(10, 10)));
    }

    public class Solution {
        public int StrToInt(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            final char[] chars = str.toCharArray();
            long res = 0, carry = 0;
            for (int i = chars.length - 1; i > 0; i--) {
                int te = chars[i] - '0';
                if (te > 9) {
                    return 0;
                }
                res += (te * Math.pow(10, carry++));
            }
            if (chars[0] == '+') {
                return (int) res;
            } else if (chars[0] == '-') {
                return (int) -res;
            } else if (chars[0] - '0' > 9) {
                return 0;
            } else {
                return (int) (res += (chars[0] - '0') * Math.pow(10, carry));
            }
        }
    }
}
