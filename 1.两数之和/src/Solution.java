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
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            Integer item = map.get(target - nums[i]);
            if (item != null) {
                res[0] = item;
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
