/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/13
 * Time: 0:05
 * Description:
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.maxArray(new int[]{1, 2, 3, 4, 5, 3, 2, 1, 0});
        System.out.println(i);
    }

    public int maxArray(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return nums[mid];
            } else if (nums[mid - 1] < nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

}
