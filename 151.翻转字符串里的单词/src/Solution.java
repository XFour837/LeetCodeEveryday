/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/4/2
 * Time: 15:57
 * Description:
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        String[] stringNum = s.trim().replaceAll("\\s+", " ").split(" ");
        for (int i = 0; i < stringNum.length; i++) {
            stringNum[i] = swapStr(stringNum[i]);
        }
        return swapStr(String.join(" ", stringNum));
    }

    private String swapStr(String str) {
        char[] charArray = str.toCharArray();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            swap(charArray, start++, end--);
        }
        return new String(charArray);
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

}
