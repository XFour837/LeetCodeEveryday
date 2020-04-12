import java.util.*;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 20:33
 * Description:
 */
class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> map.get(o2) - map.get(o1)));
        for (int num : nums) {
            Integer times = map.getOrDefault(num, 0);
            map.put(num, times + 1);
            priorityQueue.remove(num);
            priorityQueue.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }

}
