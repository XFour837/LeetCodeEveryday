/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/9/18
 * Time: 20:11
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l != null || r != null) {
            if (l == null) {
                cur.next = r;
                r = r.next;
            } else if (r == null) {
                cur.next = l;
                l = l.next;
            } else if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
