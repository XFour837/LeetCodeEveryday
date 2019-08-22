/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/22
 * Time: 23:13
 * Description:
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int zero = 0, one = 0;
            for (char c : chars) {
                if (c == '0') zero++;
                else one++;
            }
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
