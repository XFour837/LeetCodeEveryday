import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/31
 * Time: 20:29
 * Description:
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}
