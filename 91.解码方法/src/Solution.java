import javax.jws.soap.SOAPBinding;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/20
 * Time: 23:36
 * Description:
 */
class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0
                || s.startsWith("0")) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i);
            if (c != '0') dp[i] = dp[i - 1];
            String str = s.substring(i - 1, i + 1);
            if (str.startsWith("0")) continue;
            int num = Integer.parseInt(str);
            if (0 < num && num <= 26)
                dp[i] += i - 2 < 0 ? 1 : dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
