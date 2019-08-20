import java.util.LinkedList;
import java.util.Queue;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 13:21
 * Description:
 */
class SolutionGraph {

    private class Node {
        private int value;
        private int step;

        private Node(int value, int step) {
            this.value = value;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        if (n <= 0) return n;
        Node root = new Node(n, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 1;; i++) {
                int num = node.value - i * i;
                if (num == 0) {
                    return node.step + 1;
                }
                if (num < 0) break;
                if (!visited[num]) {
                    queue.add(new Node(num, node.step + 1));
                    visited[num] = true;
                }
            }
        }
        return -1;
    }
}
