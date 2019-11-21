import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/11/21
 * Time: 21:51
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(res);
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (wordDict.contains(s)) {
//            return true;
//        }
//        int length = s.length();
//        for (int i = 1; i < length; i++) {
//            String str = s.substring(0, i);
//            if (wordDict.contains(str)) {
//                String newS = s.substring(i);
//                if (wordBreak(newS, wordDict)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            String str = s.substring(0, i + 1);
            if (wordDict.contains(str)) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; i > j; j++) {
                if (dp[j]) {
                    String temp = s.substring(j + 1, i + 1);
                    if (wordDict.contains(temp)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

}
