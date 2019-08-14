/**
 * Create with 2.两数相加
 * User: 许清远
 * Date: 2019/6/11
 * Time: 19:16
 * Description:注意 5 + 5这种情况
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        boolean addFlag = false;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2;
            if (addFlag) sum++;
            if (sum >= 10) {
                addFlag = true;
                sum = sum % 10;
            } else {
                addFlag = false;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (addFlag) cur.next = new ListNode(1);
        return dummy.next;
    }
}