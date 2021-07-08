import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数和，哈希表缓存解法
 */
public class TwoSumSolution1 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 18)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 利用字符表做缓存
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
