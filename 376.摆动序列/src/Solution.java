import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/23
 * Time: 0:32
 * Description:
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        boolean[] flag = new boolean[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[j + 1]) continue;
                boolean b = nums[i] - nums[j] > 0;
                if (dp[j] == 1 || b != flag[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    flag[i] = b;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
