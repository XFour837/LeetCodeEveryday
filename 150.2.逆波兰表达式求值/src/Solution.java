import java.util.Objects;
import java.util.Stack;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 22:40
 * Description:
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (Objects.equals(token, "+")
                    || Objects.equals(token, "-")
                    || Objects.equals(token, "*")
                    || Objects.equals(token, "/")) {
                Integer num2 = Integer.parseInt(stack.pop());
                Integer num1 = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
