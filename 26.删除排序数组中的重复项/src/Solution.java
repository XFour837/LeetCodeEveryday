/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 23:00
 * Description:
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) nums[k++] = nums[i];
        }
        nums[k++] = nums[nums.length - 1];
        return k;
    }
}
