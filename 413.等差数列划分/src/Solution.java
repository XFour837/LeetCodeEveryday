/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/30
 * Time: 17:56
 * Description:
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int d1 = A[1] - A[0];
        int d2;
        int dp = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            d2 = A[i] - A[i - 1];
            if (d1 == d2) {
                sum += ++dp;
            } else {
                dp = 0;
            }
            d1 = d2;
        }
        return sum;
    }
}
