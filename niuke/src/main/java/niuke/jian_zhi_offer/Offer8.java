package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 动态规划的跳台阶问题, 可以使用自顶向下的方法
 * /   1               n = 1
 * f(n) ——  2               n = 2
 * \   f(n-1)+f(n-2)   n > 2
 * @email ai654778@vip.qq.com
 * @date 19-2-4
 */
public class Offer8 {
    public static void main(String[] args) {

    }

    public int JumpFloor(int target) {
        return dp(target);
    }

    public int recursive(int target) {
        if (target <= 2 && target > 0) {
            return target;
        }
        return recursive(target - 1) + recursive(target - 2);
    }

    private int dp(int target) {
        if (target <= 3) {
            return target;
        }
        int i = 2, j = 3;
        for (int q = 4; q <= target; q++) {
            int k = i + j;
            i = j;
            j = k;

        }
        return j;
    }
}
