/**
 * Create with 11.盛最多水的容器
 * User: 许清远
 * Date: 2019/6/15
 * Time: 19:53
 * Description:
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public static void main(String[] args) {
        int maxArea = new Solution().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int head = 0, tail = height.length - 1;
        int maxArea = 0;
        while (head != tail) {
            maxArea = Math.max(maxArea, (tail - head) * Math.min(height[head], height[tail]));
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;
    }
}
