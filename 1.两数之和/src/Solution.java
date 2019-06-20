import java.util.HashMap;
import java.util.Map;

/**
 * Create with 1.两数之和
 * User: 许清远
 * Date: 2019/6/11
 * Time: 18:13
 * Description:
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
