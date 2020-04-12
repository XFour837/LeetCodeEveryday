import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 20:08
 * Description:
 */
class Solution {

    public int[] smallestK(int[] nums, int k) {
        if (nums.length < k || k <= 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        getRes(nums, k - 1, res);
        return res;
    }

    private void getRes(int[] nums, int k,int[] res) {
        List<Integer> list = new ArrayList<>();
        int l = 0, h = nums.length - 1;
        while (true) {
            int index = partition(nums, l, h);
            if (index == k) {
                System.arraycopy(nums, 0, res, 0, k + 1);
                break;
            } else if (index < k) {
                l = index + 1;
            } else {
                h = index - 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
        int v = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i < h && nums[++i] < v);
            while (j > l && nums[--j] > v);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
