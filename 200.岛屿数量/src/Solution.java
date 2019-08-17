/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 22:35
 * Description:
 */
class Solution {

    private char[][] grid;
    private boolean[][] visited;
    private int[][] r = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + r[i][0];
            int newY = y + r[i][1];
            if (isArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
