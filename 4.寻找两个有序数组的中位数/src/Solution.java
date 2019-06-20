/**
 * Create with 4.寻找两个有序数组的中位数
 * User: 许清远
 * Date: 2019/6/11
 * Time: 20:55
 * Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) {
            throw new IllegalArgumentException();
        }

        //nums1的指针
        int i = 0;
        //nums2的指针
        int j = 0;

        int length = nums1.length + nums2.length;
        int[] nums = new int[length];

        for (int k = 0; k < nums.length; k++) {

            if (i == nums1.length) {
                nums[k] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                nums[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }

    }

}
