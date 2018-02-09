public class ThreeSumClosest {

    public static int twoSum(int start, int[] nums, int first, int result, int target) {
        int i = start;
        int j = nums.length - 1;
        // 使用绝对判断距离target的程度
        int abs = Math.abs(result - target);
        while (i < j) {
            if (i > start && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            if (Math.abs(nums[j] + nums[i] + first - target) < abs) {
                result = nums[j] + nums[i] + first;
                abs = Math.abs(result - target);
            } 
            // 重点，控制距离target的程度
            if (nums[j] + nums[i] + first > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //int result = Integer.MAX_VALUE / 2;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            result = twoSum(i + 1, nums, nums[i], result, target);
        }
        return result;
    }
}
