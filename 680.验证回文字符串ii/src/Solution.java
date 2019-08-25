/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/26
 * Time: 0:09
 * Description:
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        int bl = -1, br = -1;
        boolean isLeft = false;
        boolean isRight = false;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if (cl == cr) {
                l++;
                r--;
            } else {
                if (isLeft && isRight) {
                    return false;
                } else {
                    if (bl == -1) {
                        bl = l;
                        br = r;
                    } else {
                        l = bl;
                        r = br;
                    }
                    if (!isLeft) {
                        isLeft = true;
                        l++;
                    } else {
                        isRight = true;
                        r--;
                    }
                }
            }
        }
        return true;
    }
}
