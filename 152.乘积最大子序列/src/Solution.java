/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/9/18
 * Time: 20:29
 * Description:
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
