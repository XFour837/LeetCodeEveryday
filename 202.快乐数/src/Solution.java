import java.util.HashSet;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/10
 * Time: 12:31
 * Description:
 */
class Solution {

    public boolean isHappy(int n) {
        if (n <= 0) return false;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n >= 10) {
                int num = n % 10;
                sum += Math.pow(num, 2);
                n /= 10;
            }
            sum += Math.pow(n, 2);
            if (sum == 1) {
                return true;
            } else {
                if (set.contains(sum)) {
                    return false;
                } else {
                    set.add(sum);
                    n = sum;
                }
            }
        }
    }
}
