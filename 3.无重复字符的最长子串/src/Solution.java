import java.util.HashSet;

/**
 * Create with 3.无重复字符的最长子串
 * User: 许清远
 * Date: 2019/6/11
 * Time: 19:40
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解题思路：利用滑动窗口
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);

    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int ans = 0;
        int i = 0,j = 0;

        HashSet<Character> set = new HashSet<>();

        while (i < charArray.length && j < charArray.length) {
            if (!set.contains(charArray[j])) {
                ans = Math.max(j - i + 1, ans);
                set.add(charArray[j]);
                j++;
            } else {
                set.remove(charArray[i]);
                i++;
            }
        }

        return ans;
    }

}
