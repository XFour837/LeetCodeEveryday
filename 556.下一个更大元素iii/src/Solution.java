/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/6
 * Time: 13:35
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.nextGreaterElement(12443322);
        System.out.println(res);
    }

    public int nextGreaterElement(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        if (charArray.length == 1) {
            return -1;
        }
        int rightPoint = charArray.length - 2;
        while (charArray[rightPoint] >= charArray[rightPoint + 1]) {
            rightPoint--;
            if (rightPoint == -1) {
                return -1;
            }
        }
        int bigPoint = rightPoint + 1;
        while (bigPoint != charArray.length - 1 && charArray[bigPoint + 1] >= charArray[rightPoint]) {
            bigPoint++;
        }
        swap(charArray, rightPoint, bigPoint);
        reverse(charArray, rightPoint + 1, charArray.length - 1);
        return Integer.parseInt(new String(charArray));
    }

    private void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            swap(charArray, start++, end--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

}
