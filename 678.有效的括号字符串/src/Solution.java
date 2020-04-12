import java.util.Stack;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/11
 * Time: 12:37
 * Description:
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
        System.out.println(res);
    }

    public boolean checkValidString(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int randomNumber = 0;
        for (char c : charArray) {
            if (c == '*') {
                randomNumber++;
            } else if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    randomNumber--;
                    if (randomNumber < 0) {
                        return false;
                    }
                }
            }
        }
        return randomNumber >= stack.size();
    }
}
