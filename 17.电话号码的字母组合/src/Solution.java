import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 17:49
 * Description:
 */
class Solution {

    private List<String> list = new ArrayList<>();
    private HashMap<Character, List<Character>> map = new HashMap<>();
    private String str;
    private Integer len;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return list;
        }
        this.str = digits;
        this.len = digits.length();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        letterCombinations(new StringBuilder(), 0);
        return list;
    }

    private void letterCombinations(StringBuilder stringBuilder, int index) {
        if (index == len) {
            list.add(stringBuilder.toString());
            return;
        }
        List<Character> charList = map.get(str.charAt(index));
        for (Character c : charList) {
            letterCombinations(new StringBuilder(stringBuilder).append(c), index + 1);
        }
    }
}
