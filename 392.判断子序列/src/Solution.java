/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/23
 * Time: 1:19
 * Description:
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0 || s.length() > t.length()) return false;
        char[] target = s.toCharArray();
        char[] charArray = t.toCharArray();
        int curIndex = 0;
        char cur = target[curIndex];
        for (char c : charArray) {
            if (cur == c) {
                curIndex++;
                if (curIndex == target.length) return true;
                cur = target[curIndex];
            }
        }
        return false;
    }
}