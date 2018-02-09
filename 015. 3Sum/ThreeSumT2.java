public class Solution {

     public static void twoSum(int start, int[] nums, int target, List<List<Integer>> result) {
        first_loop:
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] + nums[i] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-target);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    continue first_loop;
                } else if (nums[j] + nums[i] < target) {
                    continue first_loop;
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            twoSum(i + 1, nums, -nums[i], result);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));
        return result;
    }
}
