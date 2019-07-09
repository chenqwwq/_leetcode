package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer48 {
    public class Solution {
        public int Add(int num1, int num2) {
            int sum, carry;
            do {

                sum = num1 ^ num2;
                // 与,表示进位位置,下次异或时可用
                carry = (num1 & num2) << 1;
                num1 = sum;
                num2 = carry;
            } while (num2 != 0);
            return num1;
        }
    }
}
