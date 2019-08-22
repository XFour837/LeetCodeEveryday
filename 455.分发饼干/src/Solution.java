import java.util.Arrays;
import java.util.Comparator;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/23
 * Time: 1:13
 * Description:
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gs = g.length - 1, ss = s.length - 1;
        int res = 0;
        while (gs >= 0 && ss >= 0) {
            if (s[ss] >= g[gs]) {
                ss--;
                gs--;
                res++;
            } else {
                gs--;
            }
        }
        return res;
    }
}
