package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 矩阵覆盖
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer10 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int i = 1, j = 2;

        while (target-- >= 2) {
            int k = i + j;
            i = j;
            j = k;
        }
        return j;
    }
}
