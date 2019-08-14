/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 22:47
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        while (cur.next != null) {
            if (cur.next.next != null
                    && cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                ListNode nextNode = cur.next;
                while (nextNode != null &&
                        nextNode.val == val) {
                    nextNode = nextNode.next;
                }
                cur.next = nextNode;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
