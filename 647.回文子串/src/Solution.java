/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 1:26
 * Description:
 */
class Solution {

    private int res = 0;
    private int len;

    public int countSubstrings(String s) {
        if (s == null || (len = s.length()) == 0) return res;
        for (int i = 0; i < s.length(); i++) {
            handler(s, i, i);
            handler(s, i, i + 1);
        }
        return res;
    }

    private void handler(String s, int start, int end) {
        while (start >= 0 && end < len && s.charAt(start--) == s.charAt(end++))
            res++;
    }

}
