import java.util.ArrayList;
import java.util.List;

/**
 * Create with 6.Z字形变换
 * User: 许清远
 * Date: 2019/6/12
 * Time: 20:26
 * Description:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：按行排序，先通过 min(s.length(), numRows) 求出一共有多少行，然后设置一个变量 down，
 * 在每次位于第一行以及最后一行的时候反向
 */
public class Solution {

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String res = new Solution().convert(str, 3);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int row = 0;
        boolean down = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if (row == 0 || row == list.size() - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : list) {
            res.append(builder);
        }

        return res.toString();

    }

}
