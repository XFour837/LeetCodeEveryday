import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 19:40
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        this.nums = candidates;
        backtracking(new ArrayList<>(), target, 0);
        return res;
    }

    private void backtracking(List<Integer> cur, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (nums[index] > target) break;
            if (nums[i] == lastUsed) continue;
            lastUsed = nums[i];
            cur.add(nums[i]);
            backtracking(cur, target - nums[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
