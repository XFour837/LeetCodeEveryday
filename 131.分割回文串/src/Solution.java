import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 16:02
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        boolean ab = new Solution().isTrue("ab");
        System.out.println(ab);
    }

    private List<List<String>> res = new ArrayList<>();
    private String s;
    private Integer length;

    public List<List<String>> partition(String s) {
        if (s == null || s.equals("")) return res;
        this.s = s;
        this.length = s.length();
        backtracking(0, new ArrayList<>());
        return res;
    }

    private void backtracking(int pos, List<String> cur) {
        if (pos == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int len = length - pos;
        for (int i = 1; i <= len; i++) {
            String str = s.substring(pos, pos + i);
            if (!isTrue(str)) continue;
            cur.add(str);
            backtracking(pos + i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isTrue(String str) {
        if (str.length() == 1) return true;
        int p1 = 0, p2 = str.length() - 1;
        while (p1 < p2) {
            if (str.charAt(p1) != str.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }

}
