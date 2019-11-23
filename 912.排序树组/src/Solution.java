import java.util.ArrayList;
import java.util.List;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/11/23
 * Time: 14:20
 * Description:
 */
class Solution {

    public List<Integer> sortArray(int[] nums) {
        HeapSort heapSort = new HeapSort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(heapSort.getRoot());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.sortArray(new int[]{5, 2, 3, 1});
        System.out.println(list);
    }

}

class HeapSort {

    private int[] nums;
    private int size;

    public HeapSort(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        for (int i = size / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftDown(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int i;
        if (left >= size) {
            return;
        } else {
            if (right >= size) {
                if (nums[left] < nums[index]) {
                    i = left;
                } else {
                    return;
                }
            } else {
                i = nums[left] < nums[right] ? left : right;
                if (nums[i] >= nums[index]) {
                    return;
                }
            }
        }
        swap(i, index);
        shiftDown(i);
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int getRoot() {
        int res = nums[0];
        swap(0, size - 1);
        size--;
        shiftDown(0);
        return res;
    }

}
