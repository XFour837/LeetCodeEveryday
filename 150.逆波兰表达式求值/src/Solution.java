import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 16:27
 * Description:
 */
class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (String token : tokens) {
            if ("+".equals(token)
                    || "-".equals(token)
                    || "*".equals(token)
                    || "/".equals(token)) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        if (!stack.isEmpty()) return Integer.parseInt(stack.pop());
        return res;
    }
}
