/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/10/13
 * Time: 0:17
 * Description:
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int a = matrix.length;
        int b = matrix[0].length;
        int[][] dp = new int[a][b];
        for (int i = 0; i < b; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < a; i++) {
            for (int j = i; j < b; j++) {
                if (matrix[i][j] != 0) {
                    if (dp[i - 1][j] != 0
                            && dp[i][j - 1] != 0
                            && dp[i - 1][j - 1] != 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = matrix[i][j];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }
}
