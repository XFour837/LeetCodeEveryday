/**
 * Create with 9.回文数
 * User: 许清远
 * Date: 2019/6/13
 * Time: 20:32
 * Description:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        boolean palindrome = new Solution().isPalindrome(-121);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x / 10 != 0 && x % 10 == 0)) {
            return false;
        }
        String str = String.valueOf(x);
        if (str.length() % 2 == 1) {
            return isPalindrome(str, str.length() / 2, str.length() / 2);
        } else {
            return isPalindrome(str, str.length() / 2 - 1, str.length() / 2);
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
}
