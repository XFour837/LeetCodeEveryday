import java.util.Iterator;
import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/9/18
 * Time: 21:00
 * Description:
 */
class MinStack {

    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(x, min);
    }

    public void pop() {
        Integer num = stack.pop();
        if (num == min) {
            min = Integer.MAX_VALUE;
            for (Integer item : stack) {
                min = Math.min(min, item);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
