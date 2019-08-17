/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 21:35
 * Description:
 */
class Solution {

    private char[][] board;
    private String word;
    private int[][] r = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = backtracking(i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean backtracking(int x, int y, int index) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (word.charAt(index) != board[x][y]) return false;
        visited[x][y] = true;
        for (int[] route : r) {
            int nextX = x + route[0];
            int nextY = y + route[1];
            if (inArea(nextX, nextY)
                    && backtracking(nextX, nextY, index + 1)) {
               return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y];
    }

}
