import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 15:31
 * Description:
 */
class Solution {

    private int len;

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        this.len = s.length();
        List<String> list = new ArrayList<>();
        backtracking(s, 0, list, res);
        return res;
    }

    private void backtracking(String s, int pos, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (pos == len) res.add(String.join(".", list));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (pos + i > len) break;
            String str = s.substring(pos, pos + i);
            if ((i > 1 && str.startsWith("0")) || Integer.parseInt(str) > 255) continue;
            list.add(str);
            backtracking(s, pos + i, list, res);
            list.remove(list.size() - 1);
        }
    }

}
