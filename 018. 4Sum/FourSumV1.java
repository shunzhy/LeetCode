public class FourSum {
    // nums数组必须是按从小到大排好序的
    public static void twoSum(int start, int[] nums, int target, int first, int second, List<List<Integer>> result) {
        // 2sum从首位开始遍历，时间复杂度为O(n)
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            if (i > start && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            if (nums[j] + nums[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(second);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                i++;
                j--;
                while(i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while(i < j && nums[j + 1] == nums[j]) {
                    j--;
                }
            } else if (nums[j] + nums[i] > target) { // 两数和大于目标值，则j--（减少两数的和）
                j--;
            } else { // 两数和小于目标值，则i++（增加两数的和）
                i++;
            }
        }
    }

    public static void threeSum(int start, int[] nums, int target, int first, List<List<Integer>> result) {
        // 转化为2SUM问题
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            twoSum(i + 1, nums, target - nums[i],first, nums[i], result);
        }
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 转化为3SUM问题
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            threeSum(i + 1, nums, target - nums[i], nums[i], result);
        }
        return result;
    }
}
