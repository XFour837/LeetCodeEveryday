import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 0:20
 * Description:
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return -1;
        int cur = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1, r = len - 1;
            int need = target - nums[i];
            while (l < r) {
                int now = nums[l] + nums[r];
                if (now == need) {
                    return target;
                } else {
                    if (Math.abs(now - need) < Math.abs(cur - target)) {
                        cur = now + nums[i];
                    }
                    if (now < need) l++;
                    else r--;
                }
            }
        }
        return cur;
    }
}
