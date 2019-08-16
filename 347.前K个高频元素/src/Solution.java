import java.util.*;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 15:35
 * Description:
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() <= k) return new ArrayList<>(map.keySet());
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (entry.getValue() > map.get(queue.peek())) {
                    queue.poll();
                    queue.add(entry.getKey());
                }
            } else {
                queue.add(entry.getKey());
            }
        }
        return new ArrayList<>(queue);
    }
}
