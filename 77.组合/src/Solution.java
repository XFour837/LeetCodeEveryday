import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 17:15
 * Description:
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return res;
        this.k = k;
        this.n = n;
        backtracking(1, new ArrayList<>());
        return res;
    }

    private void backtracking(int start, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int curSize = cur.size();
        int size = n - (k - curSize) + 1;
        for (int i = start; i <= size; i++) {
            cur.add(i);
            backtracking(i + 1, cur);
            cur.remove(curSize);
        }
    }

}
