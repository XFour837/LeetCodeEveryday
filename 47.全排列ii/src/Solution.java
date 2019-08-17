import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 16:40
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean used[];
    private int[] nums;
    private int length;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        this.nums = nums;
        this.length = nums.length;
        used = new boolean[length];
        backtracking(new ArrayList<>());
        return res;
    }

    private void backtracking(List<Integer> cur) {
        if (cur.size() == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if ((i == 0 || nums[i] != lastUsed) && !used[i]) {
                lastUsed = nums[i];
                cur.add(nums[i]);
                used[i] = true;
                backtracking(cur);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

}
