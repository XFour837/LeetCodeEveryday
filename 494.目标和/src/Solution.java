/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/31
 * Time: 20:50
 * Description:
 */
class Solution {

    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        dfs(nums, 0, S);
        return res;
    }

    private void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) res++;
            return;
        }
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
    }

}
