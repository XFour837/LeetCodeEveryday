import java.util.Stack;

/**
 * Create with 7.整数反转
 * User: 许清远
 * Date: 2019/6/12
 * Time: 21:12
 * Description:
 */
public class MySolution {

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        int reverse = solution.reverse(1534236469);
        System.out.println(reverse);
    }

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        int flag = x > 0 ? 1 : -1;

        Stack<Character> stack = new Stack<>();
        char[] array = String.valueOf(x).toCharArray();
        for (int i = flag == 1 ? 0 : 1; i < array.length; i++) {
            stack.push(array[i]);
        }

        StringBuilder builder = new StringBuilder();
        while (stack.size() > 0) {
            builder.append(stack.pop());
        }

        try {
            return Integer.parseInt(builder.toString()) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }

    }

}
