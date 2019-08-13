import java.util.TreeSet;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 23:12
 * Description:
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            if ((floor != null && Math.abs(floor - nums[i]) <= t)
                    || (ceiling != null && Math.abs(ceiling - nums[i]) <= t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) set.remove((long)nums[i - k]);
        }
        return false;
    }
}
