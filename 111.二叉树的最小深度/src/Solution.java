/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/8
 * Time: 16:42
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(minDepth, minDepth(root.left));
        if (root.right != null) minDepth = Math.min(minDepth, minDepth(root.right));
        return minDepth + 1;
    }
}
