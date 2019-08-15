import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 15:29
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int len = 0;
        ListNode check = head;
        while (check != null) {
            len++;
            check = check.next;
        }
        int leftLen = len / 2;
        ListNode rightFront = head;
        for (int i = 0; i < leftLen - 1; i++) {
            rightFront = rightFront.next;
        }
        ListNode next = rightFront.next;
        rightFront.next = null;
        rightFront = next;
        Stack<ListNode> stack = new Stack<>();
        while (rightFront != null) {
            stack.push(rightFront);
            rightFront = rightFront.next;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode nextCur = cur.next;
            ListNode pop = stack.pop();
            cur.next = pop;
            pop.next = nextCur;
            if (nextCur == null) {
                if (!stack.isEmpty()) {
                    ListNode lastPop = stack.pop();
                    cur.next.next = lastPop;
                    lastPop.next = null;
                }
            }
            cur = nextCur;
        }
    }
}
