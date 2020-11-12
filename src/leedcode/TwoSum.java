package leedcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 32, 453};
        int target = 47;
        int[] ret = twoSum(nums, target);
        System.out.println(ret[0] + "\t" + ret[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] rest = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                if (tmp == nums[j]) {
                    rest[0] = i;
                    rest[1] = j;
                }
            }
        }
        return rest;
    }

}
