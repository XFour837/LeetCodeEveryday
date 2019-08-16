import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/16
 * Time: 15:51
 * Description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) queue.add(node.next);
        }
        cur.next = null;
        return dummy.next;
    }
}
