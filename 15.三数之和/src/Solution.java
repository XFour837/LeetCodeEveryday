import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/12
 * Time: 23:23
 * Description:
 */
class Solution {

//    public static void main(String[] args) {
//        List<List<Integer>> list = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int num = nums[i];
                int l = i + 1, r = len - 1;
                while (l < r) {
                    if (num > 0) {
                        if (nums[l] > 0) break;
                    }
                    if (num < 0) {
                        if (nums[r] < 0) break;
                    }
                    int sum = num + nums[l] + nums[r];
                    if (sum == 0) {
                        res.add(Arrays.asList(num, nums[l], nums[r]));
                        do {
                            l++;
                        } while (l < len && nums[l] == nums[l - 1]);
                        do {
                            r--;
                        } while (r > 0 && nums[r] == nums[r + 1]);
                    } else if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
