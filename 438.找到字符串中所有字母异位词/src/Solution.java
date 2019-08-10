import java.util.*;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/6
 * Time: 23:23
 * Description:
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> res = new Solution().findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        Map<Character, Integer> sourceMap = new HashMap<>();
        char[] chars = p.toCharArray();
        for (char c : chars) {
            if (sourceMap.containsKey(c)) {
                sourceMap.put(c, sourceMap.get(c) + 1);
            } else {
                sourceMap.put(c, 1);
            }
        }
        
        int pLen = 0;
        int len = s.length();
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>(sourceMap);
        while (l < len - pLen + 1) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) != 0) {
                if (r - l + 1 == pLen) {
                    list.add(l);
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    l = l + 1;
                }
                map.put(c, map.get(c) - 1);
                r++;
            } else {
                if (l != r) l = r;
                else l = ++r;
                map = new HashMap<>(sourceMap);
            }
        }
        return list;
    }
}
