/**
 * Create with 14.最长公共前缀
 * User: 许清远
 * Date: 2019/6/16
 * Time: 19:33
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MySolution {

    public static void main(String[] args) {
        System.out.println(new MySolution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String base = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            for (int j = 0; j < Math.min(base.length(),strs[i].length()); j++) {
                if (base.charAt(j) == strs[i].charAt(j)) {
                    index++;
                } else {
                    break;
                }
            }
            if (index == 0) {
                base = "";
                break;
            } else {
                base = base.substring(0, index);
            }
        }
        return base;
    }
}
