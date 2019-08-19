import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 23:54
 * Description:
 */
class Solution {

    private int[][] matrix;
    private int m;
    private int n;
    private int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && !pacific[i][j]) dfs(i, j, pacific);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == m - 1 || j == n - 1) && !atlantic[i][j]) dfs(i, j, atlantic);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] ocean) {
        ocean[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (isArea(newX, newY) && !ocean[newX][newY]
                    && matrix[newX][newY] >= matrix[x][y]) {
                dfs(newX, newY, ocean);
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}