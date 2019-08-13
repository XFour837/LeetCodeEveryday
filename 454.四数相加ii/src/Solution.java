import java.util.HashMap;
import java.util.Map;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 22:03
 * Description:
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map.containsKey(0 - C[i] - D[j])) {
                    res += map.get(0 - C[i] - D[j]);
                }
            }
        }
        return res;
    }
}
