/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 22:42
 * Description:
 */
class Solution {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[k++] = nums[i];
        }
        return k;
    }
}