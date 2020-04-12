/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 20:52
 * Description:
 */
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int cur = 0;
        for (int num : nums) {
            if (num != cur) {
                return cur;
            }
            cur++;
        }
        return cur;
    }
}