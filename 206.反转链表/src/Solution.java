/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 23:43
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode l = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = l;
            l = cur;
            cur = next;
        }
        return l;
    }
}
