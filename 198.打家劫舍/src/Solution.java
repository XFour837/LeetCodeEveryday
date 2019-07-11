import java.util.Arrays;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/11
 * Time: 20:32
 * Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：动态规划
 * 状态：尝试偷取[x,n-1]区间内的房子获取一个最大值
 * 状态转移方程：f(x) = max{v(x) + f(x+2),v(x+1) + f(x+3),.....,v(n-3) + f(n-1),v(n-2),v(n-1)}
 */
//class Solution {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n == 0) return 0;
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        dp[n - 1] = nums[n - 1];
//        for (int i = n-2; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                dp[i] = Math.max(dp[i], nums[j] + ((j + 2) >= n ? 0 : dp[j + 2]));
//            }
//        }
//        return dp[0];
//    }
//}


/**
 * 状态：考虑偷取从[0,x]区间内的房子
 * 状态转移方程：f(x) = max{v(0),v(1),f(0) + v(2),f(1) + v(3),....,f(x-2) + v(x)}
 * 思路：v的区间就是[0,x]，f即代表dp，在dp不存在于式子中的时候做特殊处理
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], nums[j] + ((j - 2) >= 0 ? dp[j - 2] : 0));
            }
        }
        return dp[n - 1];
    }
}
