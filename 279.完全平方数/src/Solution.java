import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 23:27
 * Description:
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1;; j++) {
                int num = i - j * j;
                if (num < 0) break;
                dp[i] = Math.min(dp[i], dp[num] + 1);
            }
        }
        return dp[n];
    }
}
