/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/26
 * Time: 0:38
 * Description:
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (noPrimes[i]) continue;
            count++;
            for (long j = (long) i * i; j < n; j += i) {
                noPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
