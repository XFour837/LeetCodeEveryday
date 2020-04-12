/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/8
 * Time: 16:53
 * Description:
 */
class Solution {

    private static final int[][] road = new int[][]{{1, 0}, {0, 1}};

    public int movingCount(int m, int n, int k) {

    }

    private int dfs(int x, int y, int k) {

    }

    private static int sum(int num) {
        int i = 0;
        int sum = 0;
        while (num != 0) {
            int item = num % 10;
            sum += item * Math.pow(10, i++);
            num /= 10;
        }
        return sum;
    }

}
