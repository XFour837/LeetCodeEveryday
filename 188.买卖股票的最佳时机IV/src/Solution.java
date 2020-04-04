/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/25
 * Time: 13:14
 * Description:
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[j][1] = -prices[i];
                    continue;
                }
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
}
