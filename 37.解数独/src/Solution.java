import java.util.HashSet;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/31
 * Time: 22:28
 * Description:
 */
@SuppressWarnings("unchecked")
class Solution {

    private int[][] route = new int[][]{{1, 0}, {0, 1}};
    private char[] nums = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean[][] used = new boolean[9][9];
    private char[][] board;
    private HashSet[][] regionSets = new HashSet[3][3];
    private HashSet[] xSets = new HashSet[9];
    private HashSet[] ySets = new HashSet[9];

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                regionSets[i][j] = new HashSet();
            }
        }
        for (int i = 0; i < 9; i++) {
            xSets[i] = new HashSet();
            ySets[i] = new HashSet();
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        start();
        solveSudoku(0, 0);
    }

    private boolean solveSudoku(int i, int j) {
        if ((i == 8 && j == 9) || (i == 9 && j == 8)) {
            return true;
        } else if (i == 9 || j == 9) {
            return false;
        } else if (used[i][j]) {
            return solveSudoku(i, j + 1) || solveSudoku(i + 1, j);
        }
        used[i][j] = true;
        for (int[] r : route) {
            int x = i + r[0];
            int y = j + r[1];
            for (char c : nums) {
                if (isIllegal(c, i, j)) {
                    board[i][j] = c;
                    addNumInSet(c, i, j);
                    if (solveSudoku(x, y)) {
                        return true;
                    }
                    removeNumInSet(c, i, j);
                }
            }
        }
        return false;
    }

    private void start() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    used[i][j] = true;
                    addNumInSet(board[i][j], i, j);
                }
            }
        }
    }

    private void removeNumInSet(char c, int i, int j) {
        int iIndex = i / 3;
        int jIndex = j / 3;
        regionSets[iIndex][jIndex].remove(c);
        xSets[i].remove(c);
        ySets[j].remove(c);
    }

    private void addNumInSet(char c, int i, int j) {
        int iIndex = i / 3;
        int jIndex = j / 3;
        regionSets[iIndex][jIndex].add(c);
        xSets[i].add(c);
        ySets[j].add(c);
    }

    private boolean isIllegal(char c, int i, int j) {
        return !isInRegion(c, i, j) && !isInX(c, i) && !isInY(c, j);
    }

    private boolean isInRegion(char c, int i, int j) {
        int iIndex = i / 3;
        int jIndex = j / 3;
        return regionSets[iIndex][jIndex].contains(c);
    }

    private boolean isInX(char c, int i) {
        return xSets[i].contains(c);
    }

    private boolean isInY(char c, int j) {
        return ySets[j].contains(c);
    }

}
