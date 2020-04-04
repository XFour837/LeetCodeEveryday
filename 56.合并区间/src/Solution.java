import java.util.Arrays;

/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/10
 * Time: 16:03
 * Description:
 */
class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (arr1,arr2) -> {
            if (arr1[0] != arr2[0]) {
                return arr1[0] - arr2[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });
        int curFlag = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        int[] dp = new int[intervals.length];
        dp[0] = curFlag;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= min && intervals[i][0] <= max) {
                dp[i] = dp[i - 1];
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                dp[i] = ++curFlag;
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        int[][] res = new int[curFlag + 1][2];
        min = -1;
        max = -1;
        curFlag = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != curFlag) {
                if (curFlag != -1) {
                    res[curFlag][0] = min;
                    res[curFlag][1] = max;
                }
                curFlag++;
                min = intervals[i][0];
                max = intervals[i][1];
            } else {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            }
        }
        res[curFlag][0] = min;
        res[curFlag][1] = max;
        return res;
    }
}
