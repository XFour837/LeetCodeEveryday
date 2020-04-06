import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/12/1
 * Time: 12:11
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        dfs(nums, 0, new ArrayList<>(), target);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, int target) {
        if (list.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
