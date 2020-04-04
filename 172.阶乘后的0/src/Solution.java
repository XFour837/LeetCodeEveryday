/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/25
 * Time: 11:17
 * Description:
 */
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
