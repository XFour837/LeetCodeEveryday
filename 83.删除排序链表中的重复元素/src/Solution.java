/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 0:40
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
        ListNode head = util.createLinkedList(new int[]{1, 1, 2});
        ListNode listNode = new Solution().deleteDuplicates(head);
        util.printLinkedList(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) return deleteDuplicates(head.next);
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
