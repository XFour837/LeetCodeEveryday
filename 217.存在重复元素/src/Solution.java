import java.util.HashSet;
import java.util.Set;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 23:07
 * Description:
 */
class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

}
