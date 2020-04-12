/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 19:17
 * Description:
 */
public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{2, 3, 6, 98, 4, 35, 29, 101, 45});
        while (true) {
            int i = heap.get();
            if (i == -1) {
                break;
            }
            System.out.println(i);
        }
    }

}
