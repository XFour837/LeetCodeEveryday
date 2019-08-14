/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 21:30
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode before = node1;
        ListNode after = node2;
        boolean oddFlag = true;
        while (head != null) {
            if (oddFlag) {
                before.next = head;
                before = head;
            } else {
                after.next = head;
                after = head;
            }
            oddFlag = !oddFlag;
            head = head.next;
        }
        before.next = node2.next;
        after.next = null;
        return node1.next;
    }

}
