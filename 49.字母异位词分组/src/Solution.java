import java.util.*;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 22:12
 * Description:
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String k = String.valueOf(chars);
            if (!map.containsKey(k)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(k, list);
            } else {
                map.get(k).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
