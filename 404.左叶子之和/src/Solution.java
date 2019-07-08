/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/8
 * Time: 18:08
 * Description:
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node,boolean isLeft) {
        if (node.left == null && node.right == null) return isLeft ? node.val : 0;
        int sum = 0;
        if (node.left != null) sum += sumOfLeftLeaves(node.left, true);
        if (node.right != null) sum += sumOfLeftLeaves(node.right, false);
        return sum;
    }
}
