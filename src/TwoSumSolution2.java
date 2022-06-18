import java.util.Arrays;
import java.util.Comparator;

/**
 * 两数和，双指针解法
 */
class TwoSumSolution2 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n - 1;
        Integer[] map = new Integer[n];
        for (int idx = 0; idx < n; idx++) {
            map[idx] = idx;
        }
        // 需要数组有序
        Arrays.sort(map, Comparator.comparingInt(i2 -> nums[i2]));
        // 双指针两端同步逼近
        while (i < j) {
            if (nums[map[i]] + nums[map[j]] == target) {
                return new int[]{map[i], map[j]};
            } else if (nums[map[i]] + nums[map[j]] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}