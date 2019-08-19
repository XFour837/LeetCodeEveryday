/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 1:36
 * Description:
 */
class Solution {
    public int longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int res = 0;
        int[] arr = new int[256];
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'A']++;
        }
        boolean flag = false;
        for (int num : arr) {
            if (num % 2 == 1) flag = true;
            res += num / 2 * 2;
        }
        return flag ? res + 1 : res;
    }
}
