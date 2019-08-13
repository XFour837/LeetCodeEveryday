/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/13
 * Time: 23:47
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class LinkedListUtil {

    public ListNode createLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

}

class Solution {

    public static void main(String[] args) {
        LinkedListUtil util = new LinkedListUtil();
        ListNode head = util.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = new Solution().reverseBetween(head, 2, 4);
        util.printLinkedList(listNode);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode front;
        ListNode nf;
        ListNode l = null, cur;
        cur = head;
        for (int i = 1; i < m; i++) {
            l = cur;
            cur = cur.next;
        }
        front = l;
        nf = cur;
        l = cur;
        cur = cur.next;
        for (int i = m; i < n ; i++) {
            ListNode next = cur.next;
            cur.next = l;
            l = cur;
            cur = next;
        }
        if (front != null) front.next = l;
        nf.next = cur;
        return head;
    }

}
