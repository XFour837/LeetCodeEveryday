/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/30
 * Time: 17:49
 * Description:
 */
class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (dp == null || i >= dp.length || i < 0) return 0;
        return dp[j] - (i == 0 ? 0 : dp[i - 1]);
    }
}

