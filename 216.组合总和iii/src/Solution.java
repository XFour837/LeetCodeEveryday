import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 19:50
 * Description:
 */
class Solution {

    private int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(new ArrayList<>(), n, k, 0);
        return res;
    }

    private void backtracking(List<Integer> cur, int target, int k, int index) {
        if (cur.size() == k) {
            if (target == 0) res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < 9; i++) {
            if (nums[i] > target) return;
            cur.add(nums[i]);
            backtracking(cur, target - nums[i], k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}