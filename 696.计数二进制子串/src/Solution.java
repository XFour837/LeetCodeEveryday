/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 1:54
 * Description:
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int pre = 0, cur = 1;
        int len = s.length() - 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) res++;
        }
        return res;
    }
}
