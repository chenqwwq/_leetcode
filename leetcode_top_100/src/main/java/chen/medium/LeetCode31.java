package chen.medium;

/**
 * 79. Word Search - Backtracking
 *
 * @author bingxin.chen
 * @date 2019/5/13 13:15
 */
public class LeetCode31 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && backtracking(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean backtracking(char[][] board, int i, int j, String word, int index) {
            return false;
        }
    }
}
