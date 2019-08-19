/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 1:31
 * Description:
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int len;
        if ((len = s.length()) != t.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int num : cnt) {
            if (num != 0) return false;
        }
        return true;
    }
}
