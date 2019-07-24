/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 23:33
 * Description:
 */
class Solution {
    public void sortColors(int[] nums) {
        int z = -1;
        int t = nums.length;
        for (int i = 0; i < t;) {
            if (nums[i] == 0) swap(nums, ++z, i++);
            else if (nums[i] == 1) i++;
            else swap(nums, --t, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
