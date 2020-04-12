/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 21:53
 * Description:
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int i = 0, j = 0;
        for (int k = 0; k < nums1.length; k++) {
            if (i >= m) {
                nums1[k] = nums2[j++];
            } else if (j >= n) {
                nums1[k] = tmp[i++];
            } else if (tmp[i] <= nums2[j]) {
                nums1[k] = tmp[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }
    }
}
