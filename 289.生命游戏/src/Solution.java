/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/4/2
 * Time: 19:38
 * Description:
 */
class Solution {

    private final static int[] xIndex = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    private final static int[] yIndex = new int[]{1, 1, 1, 0, -1, -1, -1, 0};

    public void gameOfLife(int[][] board) {
        if (board == null || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isLive(board, i, j)) {
                    board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private boolean isLive(int[][] board, int i, int j) {
        int liveNum = 0;
        boolean isLiveNow = isLiveNow(board, i, j);
        for (int k = 0; k < 8; k++) {
            if (isLiveNow(board, i + xIndex[k], j + yIndex[k])) {
                liveNum++;
            }
        }
        return isLiveItem(liveNum, isLiveNow);
    }

    private boolean isLiveNow(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length &&(board[i][j] & 1) == 1;
    }

    private boolean isLiveItem(int num, boolean isLiveNow) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return isLiveNow;
        } else {
            return num == 3;
        }
    }

}
