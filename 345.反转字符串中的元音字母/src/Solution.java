import java.util.Arrays;
import java.util.HashSet;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/25
 * Time: 23:54
 * Description:
 */
class Solution {

    private HashSet<Character> set =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        String s = new Solution().reverseVowels(" ");
        System.out.println(s);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        int length = s.length();
        char[] charArray = s.toCharArray();
        int l = -1, r = length;
        while (true) {
            while (l < length - 1 && !set.contains(charArray[++l]));
            while (r >= 1 && !set.contains(charArray[--r]));
            if (l >= r) break;
            swap(charArray, l, r);
        }
        return String.valueOf(charArray);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
