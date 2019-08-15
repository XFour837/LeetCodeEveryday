import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 0:18
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private class Command {
        private String s;
        private TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            TreeNode node = command.node;
            if (command.s.equals("go")) {
                stack.push(new Command("print", node));
                if (node.right != null) stack.push(new Command("go", node.right));
                if (node.left != null) stack.push(new Command("go", node.left));
            } else {
                list.add(node.val);
            }
        }
        return list;
    }
}
