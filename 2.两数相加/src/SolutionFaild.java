import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Create with 2.两数相加
 * User: 许清远
 * Date: 2019/6/11
 * Time: 18:26
 * Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionFaild {

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

        int sum = 0;
        Stack<ListNode> stack = new Stack<>();

        ListNode node = l1;
        stack.push(node);
        while (node.next != null) {
            ListNode temp = node.next;
            stack.push(temp);
            node = temp;
        }

        while (!stack.isEmpty()) {
            sum += stack.pop().val * (int) Math.pow(10, stack.size());
        }

        node = l2;
        stack.push(node);
        while (node.next != null) {
            ListNode temp = node.next;
            stack.push(temp);
            node = temp;
        }

        while (!stack.isEmpty()) {
            sum += stack.pop().val * (int) Math.pow(10, stack.size());
        }

        Stack<Integer> intStack = new Stack<>();
        int length = String.valueOf(sum).length();
        while (length > 0) {
            intStack.push(sum / (int)Math.pow(10, length - 1));
            sum = sum % (int) Math.pow(10, length - 1);
            length--;
        }

        ListNode res = new ListNode(intStack.pop());
        ListNode p = res;
        while (intStack.size() != 0) {
            p.next = new ListNode(intStack.pop());
            p = p.next;
        }

        return res;

    }

}
