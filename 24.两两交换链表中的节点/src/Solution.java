/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 23:18
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null
                && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            ListNode last = node2.next;
            node2.next = node1;
            node1.next = last;
            cur.next = node2;
            cur = node1;
        }
        return dummy.next;
    }
}
