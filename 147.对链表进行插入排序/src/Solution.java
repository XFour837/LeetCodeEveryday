/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/14
 * Time: 23:54
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
        ListNode list = util.createLinkedList(new int[]{-1, 5, 3, 4, 0});
        ListNode sortList = new Solution().insertionSortList(list);
        System.out.println(sortList);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curFront = dummy;
        ListNode cur = head;
        ListNode curNext = cur.next;
        while (true) {
            if (cur.val >= curFront.val) {
                curFront = cur;
                cur = cur.next;
                if (cur == null) return dummy.next;
                curNext = curNext.next;
            } else {
                ListNode now = dummy;
                while (true) {
                    if (now.next.val >= cur.val) {
                        cur.next = now.next;
                        now.next = cur;
                        curFront.next = curNext;
                        if (curNext == null) return dummy.next;
                        cur = curNext;
                        curNext = curNext.next;
                        break;
                    } else {
                        now = now.next;
                    }
                }
            }
        }
    }
}
