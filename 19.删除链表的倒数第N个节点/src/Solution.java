/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 0:48
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode tail;
        for (int i = 0; i < n + 1; i++) {
            if (front == null)
                return head.next;
            front = front.next;
        }
        tail = head;
        while (front != null) {
            front = front.next;
            tail = tail.next;
        }
        ListNode deleteNode = tail.next;
        tail.next = deleteNode.next;
        deleteNode.next = null;
        return head;
    }
}
