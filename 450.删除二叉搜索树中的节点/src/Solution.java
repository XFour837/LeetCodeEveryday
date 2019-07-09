/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/9
 * Time: 13:21
 * Description:
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {



    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null && root.left == null) return null;
            if (root.right == null || root.left == null) return root.left == null ? root.right : root.left;
            TreeNode min = minNode(root.right);
            min.right = deleteMinNode(root.right);  //1
            min.left = root.left;   //2       1 和 2 的位置不可以交换！！！！
            return min;
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }

    //获取最小节点
    private TreeNode minNode(TreeNode node) {
        if (node.left == null) return node;
        return minNode(node.left);
    }

    //删除最小节点，返回删除最小节点之后二叉搜索树的根
    private TreeNode deleteMinNode(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = deleteMinNode(node.left);
        return node;
    }
}
