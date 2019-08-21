/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/21
 * Time: 1:46
 * Description:
 */
class Solution {
    public int maxProfit(int[] prices) {
        int i_1 = Integer.MIN_VALUE;
        int i_0 = 0;
        int pre = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = i_0;
            i_0 = Math.max(i_0, i_1 + prices[i]);
            i_1 = Math.max(i_1, pre - prices[i]);
            pre = tmp;
        }
        return i_0;
    }
}
