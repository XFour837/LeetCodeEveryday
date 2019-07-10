/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/10
 * Time: 19:08
 * Description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int index = searchBreakIndex(nums, 0, nums.length - 1);
        if (nums[index] == target) return index;
        else if (index == 0) return searchResult(nums, 1, nums.length - 1, target);
        else if (target < nums[0]) return searchResult(nums, index + 1, nums.length - 1, target);
        else return searchResult(nums, 0, index - 1, target);
    }

    private int searchBreakIndex(int[] arr, int i, int j) {
        int l = i, h = j;
        if (arr[l] <= arr[h]) return 0;
        int mid;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] < arr[i]) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    private int searchResult(int[] arr, int l, int h, int k) {
        int mid;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] < k) l = mid + 1;
            else h = mid - 1;
        }
        return -1;
    }
}