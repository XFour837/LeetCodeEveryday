import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 23:54
 * Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    class Command {
        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Command> stack = new Stack<>();
        Command rootCommand = new Command("go", root);
        stack.push(rootCommand);
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            TreeNode node = command.node;
            if (command.s.equals("go")) {
                if (node.right != null) stack.push(new Command("go", node.right));
                stack.push(new Command("print", node));
                if (node.left != null) stack.push(new Command("go", node.left));
            } else {
                list.add(node.val);
            }
        }
        return list;
    }
}
