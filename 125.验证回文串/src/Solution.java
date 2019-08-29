/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/25
 * Time: 0:27
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        int length = s.length();
        int l = 0, r = length - 1;
        while (true) {
            char cl = '-';
            char cr = '-';
            while (l < length) {
                cl = s.charAt(l);
                if (('a' <= cl && cl <= 'z')
                        || ('A' <= cl && cl <= 'Z')) {
                    break;
                }
                l++;
            }
            while (r >= 0) {
                cr = s.charAt(r);
                if (('a' <= cr && cr <= 'z')
                        || ('A' <= cr && cr <= 'Z')) {
                    break;
                }
                r--;
            }
            if (cl == cr || Math.abs(cl - cr) == 32 || (l == length && r == -1)) {
                l++;
                r--;
            } else {
                return false;
            }
            if (l > r) break;
        }
        return true;
    }
}
