import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/7/8
 * Time: 19:51
 * Description:给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(root.val));
            return list;
        }
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        List<String> res = new ArrayList<>();
        for (String item : leftList) res.add(root.val + "->" + item);
        for (String item : rightList) res.add(root.val + "->" + item);
        return res;
    }
}
