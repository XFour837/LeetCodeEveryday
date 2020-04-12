import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 22:02
 * Description:
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals,((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= max) {
                min = Math.min(interval[0], min);
                max = Math.max(interval[1], max);
            } else {
                list.add(new int[]{min, max});
                min = interval[0];
                max = interval[1];
            }
        }
        list.remove(0);
        list.add(new int[]{min, max});
        return list.toArray(new int[list.size()][2]);
    }
}
