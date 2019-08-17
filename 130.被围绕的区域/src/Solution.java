import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 22:46
 * Description:
 */
class Solution {

    private int m;
    private int n;
    private boolean[][] visited;
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private char[][] board;

    private final int FIRST = 1;
    private final int SECOND = 2;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && !visited[i][j] && board[i][j] == 'O') {
                    dfs(i, j, FIRST);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    dfs(i, j, SECOND);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int x, int y, int flag) {
        visited[x][y] = true;
        if (flag == FIRST) board[x][y] = '-';
        else if (flag == SECOND) board[x][y] = 'X';
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (isArea(newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                dfs(newX, newY, flag);
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
