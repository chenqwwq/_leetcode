package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 只能想到递归,不知道怎么判断边界. 网上说用短路特性+递归
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer47 {
    public class Solution {
        public int Sum_Solution(int n) {
            int sum = n;
            boolean temp = sum > 0 && ((sum += Sum_Solution(n - 1)) > 0);
            return sum;
        }
    }
}
