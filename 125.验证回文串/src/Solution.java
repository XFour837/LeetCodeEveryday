/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/25
 * Time: 0:27
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] == chars[r]
                    || Math.abs(chars[l] - chars[r]) == 32) {
                while (!(('0' < chars[++l] &&  chars[l] < '9')
                        || ('A' < chars[l] &&  chars[l] < 'Z')
                        || ('a' < chars[l] &&  chars[l] < 'z')));
                while (!(('0' < chars[++r] &&  chars[r] < '9')
                        || ('A' < chars[r] &&  chars[r] < 'Z')
                        || ('a' < chars[r] &&  chars[r] < 'z')));
            } else {
                return false;
            }
        }
        return true;
    }
}
