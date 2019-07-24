/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 22:33
 * Description:
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[k++] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
