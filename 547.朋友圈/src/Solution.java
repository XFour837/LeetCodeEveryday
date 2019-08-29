/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/30
 * Time: 2:25
 * Description:
 */
class Solution {

    private int res = 0;
    private boolean[] used;
    private int length;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return res;
        this.length = M.length;
        this.used = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!used[i] && M[i][i] == 1) {
                res++;
                findCircleNum(M, i);
            }
        }
        return res;
    }

    private void findCircleNum(int[][] M, int x) {
        used[x] = true;
        for (int i = 0; i < length; i++) {
            if (!used[i] && M[x][i] == 1) {
                findCircleNum(M, i);
            }
        }
    }

}
