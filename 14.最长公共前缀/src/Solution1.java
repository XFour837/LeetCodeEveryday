/**
 * Create with 14.最长公共前缀
 * User: 许清远
 * Date: 2019/6/16
 * Time: 19:45
 * Description:
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(new Solution1().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));;
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String base = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(base) != 0) {
                base = base.substring(0, base.length() - 1);
                if (base.isEmpty()) {
                    return "";
                }
            }
        }

        return base;

    }

}
