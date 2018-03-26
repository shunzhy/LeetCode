public class RemoveElement {

    /**
     * 这边只需要关注不等于val的，直接原数组做替换即可
     * @param
     * @Author zhengyingshun
     * @Date 2018/3/26 17:29
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
