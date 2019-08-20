import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/11
 * Time: 20:32
 * Description:
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
