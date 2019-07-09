package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 二进制`1`的个数
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer11 {
    public int NumbersOf1(int n) {
        int count = 0;
        // 把一个数字减一再`与`上原数字会让数字最右边的1变为0
        // 可以简单理解为一次少一个1
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;

    }
}
