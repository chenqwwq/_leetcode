package niuke.jian_zhi_offer;


/**
 * @author chen
 * @description 调整数组元素位置, 使奇数一直在偶数前
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer13 {
    public static void main(String[] args) {
        new Offer13().reOrderArray1(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    /**
     * 该种方法不能保证偶数的顺序性
     *
     * @param array
     */
    public void reOrderArray1(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        // even表示最后一个奇数再往后的一个数值
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            // 偶数时保持不变,奇数时和指定位置交换
            if (!judge(array[i])) {
                // 不相等表示中间是偶数,将偶数整体向后移动
                // 移动的区间时even~i-1
                // 实现备份当前元素
                int backup = array[i];
                backOnePosition(array, even, i - 1);
                array[even] = backup;
                even++;
            }
        }
    }

    /**
     * 位运算判断奇偶数
     *
     * @return true -> 偶数,false -> 奇数
     */
    private boolean judge(int i) {
        // 奇偶的判断就在二进制位的最后一位,是1则为奇数
        return (i & 1) != 1;
    }

    /**
     * 位操作完成数组中元素调换
     */
    private void swap(int i, int j, int[] array) {
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    /**
     * 往后移动一个位置
     * 将start～end位置的元素 平移到start+1,end+1的位置
     */
    public void backOnePosition(int[] arr, int start, int end) {
        for (int i = end; i >= start; i--) {
            arr[i + 1] = arr[i];
        }
    }
}
