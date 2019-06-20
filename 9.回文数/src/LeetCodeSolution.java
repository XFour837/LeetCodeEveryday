/**
 * Create with 9.回文数
 * User: 许清远
 * Date: 2019/6/13
 * Time: 20:50
 * Description:
 */
public class LeetCodeSolution {

    public static void main(String[] args) {
        new LeetCodeSolution().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x / 10 != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        int pop;
        while (x > rev) {
            pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }

        return rev == x || x == rev / 10;

    }

}
