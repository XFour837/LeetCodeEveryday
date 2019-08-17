import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 20:32
 * Description:
 */
class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int[] nums = new int[10];
    private List<List<Integer>> numList;

    {
        map.put(0, 8);
        map.put(1, 4);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 32);
        map.put(5, 16);
        map.put(6, 8);
        map.put(7, 4);
        map.put(8, 2);
        map.put(9, 1);
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num < 0) return list;
        getNum(num);
        for (List<Integer> timeList : numList) {
            int hourSum = 0;
            int minSum = 0;
            for (Integer time : timeList) {
                if (time < 4) {
                    hourSum += map.get(time);
                } else {
                    minSum += map.get(time);
                }
            }
            if (hourSum > 11 || minSum > 59) continue;
            if (minSum < 10) list.add(hourSum + ":0" + minSum);
            else list.add(hourSum + ":" + minSum);
        }
        return list;
    }

    private void getNum(int num) {
        this.numList = new ArrayList<>();
        backtracking(new ArrayList<>(), 0, num);
    }

    private void backtracking(List<Integer> cur, int index, int num) {
        if (cur.size() == num) {
            numList.add(new ArrayList<>(cur));
            return;
        }
        int size = nums.length - (num - cur.size());
        for (int i = index; i <= size; i++) {
            cur.add(nums[i]);
            backtracking(cur, i + 1, num);
            cur.remove(cur.size() - 1);
        }
    }

}
