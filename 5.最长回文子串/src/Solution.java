import java.util.ArrayList;

/**
 * Create with 5.最长回文子串
 * User: 许清远
 * Date: 2019/6/12
 * Time: 1:37
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解题思路：中心扩展算法
 */
public class Solution {

    public static void main(String[] args) {
        String str = "babad";
        String res = new Solution().longestPalindrome(str);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {

        if (s.equals("")) {
            return "";
        }

        int start = 0,end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = getLen(s, i, i);
            int len2 = getLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private int getLen(String s, int l, int r) {

        int len = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            len = r - l + 1;
            l--;
            r++;
        }

        return len;
    }
}
