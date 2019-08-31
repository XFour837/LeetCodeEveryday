import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/18
 * Time: 0:42
 * Description:
 */
class Solution {

    private boolean[] rd;
    private boolean[] ld;
    private boolean[] clo;
    private int n;
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return res;
        this.n = n;
        this.rd = new boolean[2 * n - 1];
        this.ld = new boolean[2 * n - 1];
        this.clo = new boolean[n];
        solveNQueens(0, new ArrayList<>());
        return res;
    }

    private void solveNQueens(int index, List<String> list) {
        if (index == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!clo[i] && !ld[i + index] && !rd[n - 1 - (index - i)]) {
                clo[i] = true;
                ld[i + index] = true;
                rd[n - 1 - (index - i)] = true;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(".");
                }
                sb.setCharAt(i, 'Q');
                list.add(sb.toString());
                solveNQueens(index + 1, list);
                list.remove(list.size() - 1);
                clo[i] = false;
                ld[i + index] = false;
                rd[n - 1 - (index - i)] = false;
            }
        }
    }

}
