package chen.easy;

/**
 * @author CheNbXxx
 * @description HashTable相关
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 10:43
 */
public class LeetCode771 {
    public static void main(String[] args) {
        System.out.println((int) 'Z');
        System.out.println((int) 'z');
    }

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int[] hashTable = new int[52];
            final char[] chars = J.toCharArray();
            for (char c : chars) {
                hashTable[c - 'A'] = 1;
            }
            int count = 0;
            for (char c : S.toCharArray()) {
                if (hashTable[c - 'A'] == 1) {
                    count++;
                }
            }
            return count;
        }
    }
}
