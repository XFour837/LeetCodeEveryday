/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 23:07
 * Description:
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int k = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != nums[i+2]) nums[k++] = nums[i];
        }
        nums[k++] = nums[nums.length - 2];
        nums[k++] = nums[nums.length - 1];
        return k;
    }
}
