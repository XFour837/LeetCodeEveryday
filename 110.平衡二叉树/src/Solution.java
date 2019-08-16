/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 16:57
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        height(root);
        return res;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right) + 1;
    }
}
