/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/29
 * Time: 23:59
 * Description:
 */
class Solution {

//    public int mySqrt(int x) {
//        int l = 1, h = x;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            int sqrt = x / mid;
//            if (sqrt == mid) {
//                return sqrt;
//            } else if (sqrt > mid) {
//                l = mid + 1;
//            } else {
//                h = mid - 1;
//            }
//        }
//        return h;
//    }

    public int mySqrt(int x) {
        int pre = 0;
        for (int i = 1; i < 50000; i++) {
            if (i * i > x || i * i < 0) return pre;
            pre = i;
        }
        return -1;
    }

}
