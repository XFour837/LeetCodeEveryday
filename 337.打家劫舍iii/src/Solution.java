/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/21
 * Time: 1:37
 * Description:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int rob(TreeNode root) {
        int[] res = getRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] getRob(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;
        int[] right = getRob(node.right);
        int[] left = getRob(node.left);
        res[0] = node.val + right[1] + left[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

}
