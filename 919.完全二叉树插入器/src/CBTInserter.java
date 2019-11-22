import java.util.LinkedList;
import java.util.Queue;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/11/22
 * Time: 16:19
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        TreeNode target = new TreeNode(v);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            } else {
                node.left = target;
                return node.val;
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                node.right = target;
                return node.val;
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
