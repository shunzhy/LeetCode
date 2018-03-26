public class RemoveDuplicates {

    /**
     * 使用map
     * @param
     * @Author zhengyingshun
     * @Date 2018/3/26 16:22
     */
    public int removeDuplicates(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                if (i != index) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return map.size();
    }

    /**
     * 使用set
     * @param
     * @Author zhengyingshun
     * @Date 2018/3/26 16:23
     */
    public int removeDuplicates1(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                if (i != index) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return set.size();
    }
}
