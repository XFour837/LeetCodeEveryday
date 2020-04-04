/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/25
 * Time: 13:33
 * Description:
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i] - fee);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
}
