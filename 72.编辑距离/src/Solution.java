/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/6
 * Time: 13:02
 * Description:
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int w1l = word1.length();
        int w2l = word2.length();
        int[][] dp = new int[w1l + 1][w2l + 1];
        for (int i = 0; i <= w1l; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2l; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1l; i++) {
            for (int j = 1; j <= w2l; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[w1l][w2l];
    }
}
