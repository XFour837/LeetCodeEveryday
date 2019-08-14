/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 0:52
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode before = node1;
        ListNode after = node2;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = node2.next;
        return node1.next;
    }
}
