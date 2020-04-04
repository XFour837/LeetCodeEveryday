/**
 * Create with LeetCodeEveryday
 * User: 许清远
 * Date: 2020/4/4
 * Time: 17:38
 * Description:
 */
class Solution {

//    public int trap(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int[][] dp = new int[height.length][2];
//        dp[0][0] = height[0];
//        dp[height.length - 1][1] = height[dp.length - 1];
//        for (int i = 1; i < height.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
//        }
//        for (int i = height.length - 2; i >= 0; i--) {
//            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
//        }
//        int res = 0;
//        for (int i = 1; i < dp.length - 1; i++) {
//            res += Math.min(dp[i][0], dp[i][1]) - height[i];
//        }
//        return res;
//    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right++];
            }
        }
        return res;
    }

}
