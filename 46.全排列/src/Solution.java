import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 16:18
 * Description:
 */
class Solution {

    private boolean[] hasUsed;
    private int[] nums;
    private int length;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        this.nums = nums;
        this.length = nums.length;
        this.hasUsed = new boolean[length];
        backtracking(new ArrayList<>());
        return res;
    }

    private void backtracking(List<Integer> cur) {
        if (cur.size() == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (hasUsed[i]) continue;
            cur.add(nums[i]);
            hasUsed[i] = true;
            backtracking(cur);
            cur.remove(cur.size() - 1);
            hasUsed[i] = false;
        }
    }

}
