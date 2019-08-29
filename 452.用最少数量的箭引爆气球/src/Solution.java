import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/29
 * Time: 21:29
 * Description:
 */
class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, ((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));
        int right = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                right = points[i][1];
                res++;
            }
        }
        return res;
    }
}
