import java.util.ArrayList;
import java.util.List;

/**
 * Create with CZ
 * User: 许清远
 * Date: 2020/3/10
 * Time: 16:39
 * Description:
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;

    }
}

class BSTIterator {

    private int curIndex = 0;
    private List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(curIndex++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < list.size();
    }

}
