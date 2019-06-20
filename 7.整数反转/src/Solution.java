/**
 * Create with 7.整数反转
 * User: 许清远
 * Date: 2019/6/13
 * Time: 20:01
 * Description:
 */
public class Solution {

    public static void main(String[] args) {
        int res = new Solution().reverse(-1234);
        System.out.println(res);
    }

    public int reverse(int x) {
        int res = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE && pop < -8)) return 0;
            res = res * 10 + pop;
        }
        return res;
    }

}
