import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 22:00
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (l1 != null) {
            l1Stack.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2);
            l2 = l2.next;
        }
        boolean addFlag = false;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int num1 = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
            int num2 = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;
            int sum = num1 + num2;
            if (addFlag) sum++;
            if (sum >= 10) {
                sum = sum % 10;
                addFlag = true;
            } else {
                addFlag = false;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (addFlag) cur.next = new ListNode(1);
        return reverseList(node.next);
    }

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = node.next;
        ListNode res = reverseList(next);
        next.next = node;
        node.next = null;
        return res;
    }

}
