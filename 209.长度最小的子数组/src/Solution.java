/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/6
 * Time: 23:01
 * Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (nums[0] >= s) return 1;
        int start = 0, end = 1, cur = nums[start] + nums[end];
        int min = Integer.MAX_VALUE;
        while (end < len) {
            if (cur >= s) {
                min = Math.min(min, end - start + 1);
                cur -= nums[start++];
            } else {
                if (++end == len) break;
                cur += nums[end];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
