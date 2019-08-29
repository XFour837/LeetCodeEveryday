import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/29
 * Time: 21:12
 * Description:
 */
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        queue.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            Character c = queue.poll();
            Integer times = map.get(c);
            for (Integer i = 0; i < times; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
