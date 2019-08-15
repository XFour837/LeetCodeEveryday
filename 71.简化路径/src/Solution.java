import java.util.Stack;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/15
 * Time: 17:11
 * Description:
 */
class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String item : split) {
            switch (item) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.push(item);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        if (size == 0) {
            return "/";
        } else {
            String[] arr = new String[size];
            for (int i = size - 1; i >= 0 ; i--) {
                arr[i] = stack.pop();
            }
            for (int i = 0; i < size; i++) {
                stringBuilder.append("/").append(arr[i]);
            }
        }
        return stringBuilder.toString();
    }
}
