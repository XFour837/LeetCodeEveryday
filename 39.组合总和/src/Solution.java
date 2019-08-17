import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 19:07
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        this.nums = candidates;
        combinationSum(target, new ArrayList<>(), 0);
        return res;
    }

    private void combinationSum(int target, List<Integer> cur, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) break;
            cur.add(nums[i]);
            combinationSum(target - nums[i], cur, i);
            cur.remove(cur.size() - 1);
        }
    }

}
