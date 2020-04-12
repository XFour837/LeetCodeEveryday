/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 22:51
 * Description:
 */
class Solution {

    public void nextPermutation(int[] nums) {
        int tail = nums.length - 1;
        int front = tail - 1;
        while (true) {
            if (tail == 0) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            if (nums[front] < nums[tail]) {
                break;
            } else {
                front--;
                tail--;
            }
        }
        for (int i = front + 1; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[front]) {
                swap(nums, front, i);
                reverse(nums, front + 1, nums.length - 1);
                return;
            }
        }
        swap(nums, front, nums.length - 1);
        reverse(nums, front + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
