/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/25
 * Time: 23:42
 * Description:
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        if (c == 1 || c == 0) return true;
        int l = 0, r = (int) Math.sqrt(c) + 1;
        while (l <= r) {
            int num;
            if ((num = l * l + r * r) == c) {
                return true;
            } else if (num < c) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
