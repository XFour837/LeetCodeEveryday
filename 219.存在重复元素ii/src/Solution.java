import java.util.HashSet;
import java.util.Set;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 23:02
 * Description:
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
                if (set.size() == k + 1) {
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
}
