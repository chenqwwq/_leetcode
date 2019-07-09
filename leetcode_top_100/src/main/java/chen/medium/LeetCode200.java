package chen.medium;

/**
 * 200. Number of Islands
 *
 * @author chen
 * @date 19 -4-27
 */
public class LeetCode200 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(new LeetCode200().new Solution().numIslands(chars));
    }

    /**
     * The type Solution.
     */
    class Solution {
        /**
         * 岛屿标记
         */
        private static final char LAND = '1';

        /**
         * 水标记
         */
        private static final char WATER = '0';

        /**
         * Num islands int.
         *
         * @param grid the grid
         * @return the int
         */
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int horizontalLen = grid.length, verticalLen = grid[0].length;
            int res = 0;

            // 遍历数组
            for (int i = 0; i < horizontalLen; i++) {
                for (int j = 0; j < verticalLen; j++) {
                    // 如果是`1`,则遍历全部相邻地址并置为FILL_VALUE
                    if (grid[i][j] == LAND) {
                        dfs(grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j) {
            // dfs遍历将连接的1全部变为0
            if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == WATER) {
                return;
            }
            grid[i][j] = WATER;

            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
