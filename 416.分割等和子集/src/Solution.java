import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/21
 * Time: 23:26
 * Description:
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int cap = sum / 2;
        boolean[] dp = new boolean[cap + 1];
        for (int i = 0; i <= cap; i++) {
            dp[i] = i == nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = cap; j >= nums[i] ; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[cap];
    }
}
