/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 17:38
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int res = -1;
    private int cur = 0;
    private int target;

    public int kthSmallest(TreeNode root, int k) {
        this.target = k;
        kthSmallest(root);
        return res;
    }

    private void kthSmallest(TreeNode root) {
        if (root == null) return;
        kthSmallest(root.left);
        if (++cur == target) {
            res = root.val;
            return;
        }
        kthSmallest(root.right);
    }

}
