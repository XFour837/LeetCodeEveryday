/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/25
 * Time: 12:49
 * Description:
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], i > 1 ? dp[i - 2][0] - prices[i] : -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
