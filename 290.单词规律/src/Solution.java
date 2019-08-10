import java.util.HashMap;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/10
 * Time: 12:45
 * Description:
 */
class Solution {

    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] arr = str.split(" ");
        if (chars.length != arr.length) return false;
        HashMap<String, Character> strMap = new HashMap<>();
        HashMap<Character, String> charMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Character c = strMap.get(arr[i]);
            if (c != null && c != chars[i])
                return false;
            String s = charMap.get(chars[i]);
            if (s != null && !s.equals(arr[i]))
                return false;
            strMap.put(arr[i], chars[i]);
            charMap.put(chars[i], arr[i]);
        }
        return true;
    }
}
