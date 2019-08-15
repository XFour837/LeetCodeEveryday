/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 15:51
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode check = head;
        while (check != null) {
            len++;
            check = check.next;
        }
        int mid = len >> 1;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < mid; i++) {
            right = right.next;
        }
        right = reverse(right);
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode next = node.next;
        ListNode res = reverse(next);
        next.next = node;
        node.next = null;
        return res;
    }

}
