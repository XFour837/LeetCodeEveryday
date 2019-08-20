/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/21
 * Time: 0:37
 * Description:
 */
class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        dp1[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp1[i] = nums[i] + (i - 2 >= 0 ? dp1[i - 2] : 0);
            dp1[i] = Math.max(dp1[i], dp1[i - 1]);
        }
        dp2[0] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int dpIndex = i - 1;
            dp2[dpIndex] = nums[i] + (dpIndex - 2 >= 0 ? dp2[dpIndex - 2] : 0);
            dp2[dpIndex] = Math.max(dp2[dpIndex], dp2[dpIndex - 1]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }

}
