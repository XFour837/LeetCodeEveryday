/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 22:39
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
