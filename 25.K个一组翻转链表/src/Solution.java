/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 23:26
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (true) {
            ListNode front = cur.next;
            ListNode check = cur;
            for (int i = 0; i < k; i++) {
                if (check.next == null)
                    return dummy.next;
                check = check.next;
            }
            ListNode node1 = front;
            ListNode node2 = node1.next;
            for (int i = 1; i < k; i++) {
                ListNode next = node2.next;
                node2.next = node1;
                node1 = node2;
                node2 = next;
            }
            cur.next = node1;
            front.next = node2;
            cur = front;
        }
    }
}
