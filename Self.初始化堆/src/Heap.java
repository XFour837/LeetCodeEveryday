/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/12
 * Time: 19:04
 * Description:
 */
public class Heap {

    private final int[] nums;
    private int size;

    public Heap(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        heapify();
    }

    public int get() {
        if (size == 0) {
            return -1;
        }
        int res = nums[0];
        size--;
        if (size >= 0) {
            swap(nums, 0, size);
            siftDown(0);
        }
        return res;
    }

    private void heapify() {
        for (int i = nums.length / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int index) {
        while (getLeftChild(index) < size) {
            int swpIndex = getLeftChild(index);
            int rightChild = getRightChild(index);
            if (rightChild < size && nums[swpIndex] < nums[rightChild]) {
                swpIndex = rightChild;
            }
            if (nums[swpIndex] > nums[index]) {
                swap(nums, index, swpIndex);
                index = swpIndex;
            } else {
                return;
            }
        }
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
