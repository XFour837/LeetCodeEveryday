/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 23:25
 * Description:
 */
class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (numbers.length == 1 || numbers[0] < numbers[numbers.length - 1]) {
            return numbers[0];
        }
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (numbers[mid] > numbers[h]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[h]) {
                h = mid;
            } else {
                h--;
            }
        }
        return numbers[l];
    }
}
