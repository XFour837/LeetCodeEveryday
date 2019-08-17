import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 20:20
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        this.nums = nums;
        backtracking(new ArrayList<>(), 0);
        return res;
    }

    private void backtracking(List<Integer> cur, int index) {
        res.add(new ArrayList<>(cur));
        if (index == nums.length) return;
        int lastUsed = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == lastUsed) continue;
            lastUsed = nums[i];
            cur.add(nums[i]);
            backtracking(cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
