/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/9/18
 * Time: 21:10
 * Description:
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }
}
