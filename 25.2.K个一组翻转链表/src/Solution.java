/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 18:08
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (true) {
            ListNode front = cur.next;
            ListNode check = front;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return dummy.next;
                }
                check = check.next;
            }
            ListNode node1 = front;
            ListNode node2 = front.next;
            for (int i = 1; i < k; i++) {
                ListNode next = node2.next;
                node2.next = node1;
                node1 = node2;
                node2 = next;
            }
            front.next = node2;
            cur.next = node1;
            cur = front;
        }
    }

}
