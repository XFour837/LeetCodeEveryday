import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/21
 * Time: 23:46
 * Description:
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < dp.length; i++) {
            if (i % coins[0] == 0) dp[i] = i / coins[0];
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
