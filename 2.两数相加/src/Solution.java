/**
 * Create with 2.两数相加
 * User: 许清远
 * Date: 2019/6/11
 * Time: 19:16
 * Description:注意 5 + 5这种情况
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);

        System.out.println("test");
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("ListNode must not be null");
        }

        int num = 0;

        ListNode res = new ListNode((l1.val + l2.val) % 10);
        num = (l1.val + l2.val) / 10;
        ListNode p = res;
        l1 = l1.next;
        l2 = l2.next;

        while (true) {
            if (l1 == null && l2 == null && num == 0) {
                break;
            }

            if (l1 == null) {
                l1 = new ListNode(0);
            }

            if (l2 == null) {
                l2 = new ListNode(0);
            }

            p.next = new ListNode((l1.val + l2.val + num) % 10);
            num = (l1.val + l2.val + num) / 10;

            l1 = l1.next;
            l2 = l2.next;

            p = p.next;
        }

        return res;
    }

}
