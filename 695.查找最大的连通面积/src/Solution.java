/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/30
 * Time: 2:08
 * Description:
 */
class Solution {

    private int max = 0;
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] used;
    private int cur;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return max;
        this.used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!used[i][j] && grid[i][j] == 1) {
                    cur = 0;
                    maxAreaOfIsland(grid, i, j);
                    max = Math.max(cur, max);
                }
            }
        }
        return max;
    }

    private void maxAreaOfIsland(int[][] grid, int x, int y) {
        cur++;
        used[x][y] = true;
        for (int[] route : d) {
            int newX = x + route[0];
            int newY = y + route[1];
            if (newX >= 0 && newX < grid.length
                    && newY >= 0 && newY < grid[0].length
                    && !used[newX][newY] && grid[newX][newY] == 1) {
                maxAreaOfIsland(grid, newX, newY);
            }
        }
    }
}
