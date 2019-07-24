/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/24
 * Time: 23:45
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int res = new Solution().findKthLargest(nums, 2);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums.length > k) return 0;
        int l = 0, h = nums.length - 1;
        while (true) {
            int index = partition(nums, l, h);
            if (index == k - 1) break;
            else if (index < k - 1) l = index + 1;
            else h = index - 1;
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l, j = r + 1;
        while (true) {
            while (i != r && nums[++i] > v);
            while (j != l && nums[--j] < v);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
