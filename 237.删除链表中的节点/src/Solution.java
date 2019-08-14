/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 0:36
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }
}
