/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/11/22
 * Time: 15:57
 * Description: 给一个 N ，生成一个 N*N 的矩阵，矩阵最外面一圈是 1 ，里面一圈是 2 ，再里面是 3 ，以此类推。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
    }

    public void generate(int N) {
        N = 2 * N;
        int flag = 0;
        for (int i = 1; i <= N / 2; i++) {
            for (int j = 1; j <= flag; j++) {
                System.out.print(j + " ");
            }
            for (int j = 0; j < N - 2 * flag; j++) {
                System.out.print(i + " ");
            }
            for (int j = flag; j >= 1; j--) {
                System.out.print(j + " ");
            }
            flag++;
            System.out.println();
        }
        for (int i = N / 2; i >= 1; i--) {
            for (int j = 1; j <= flag; j++) {
                System.out.print(j + " ");
            }
            for (int j = 0; j < N - 2 * flag; j++) {
                System.out.print(i + " ");
            }
            for (int j = flag; j >= 1; j--) {
                System.out.print(j + " ");
            }
            flag--;
            System.out.println();
        }
    }

}
