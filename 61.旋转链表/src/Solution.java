/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 0:59
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        int real = k % len;
        if (real == 0) return head;
        ListNode first, front, tail = head;
        for (int i = 0; i < real; i++) {
            tail = tail.next;
        }
        first = head;
        front = first.next;
        while (tail.next != null) {
            first = first.next;
            front = front.next;
            tail = tail.next;
        }
        tail.next = head;
        first.next = null;
        return front;
    }
}
