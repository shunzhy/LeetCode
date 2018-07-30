package com.shun.java.LeetCode;

/**
 * Search Insert Position
 * @author zhengyingshun
 * @date 2018-07-27 17:20
 */
public class SearchInsertPosition {

    /**
     * assume no duplicates in the array.
     * @Author zhengyingshun
     * @Date 2018/7/27 17:20
     */
    public int searchInsert(int[] nums, int target) {
        // 数组为空
        if (nums.length == 0) {
            return 0;
        }
        // 目标值大于数组最大值
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    /**
     * 二分搜索
     * @Author zhengyingshun
     * @Date 2018/7/30 8:37
     */
    public int searchInsert(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return start;
        }

        int mid = (start + end) / 2;
        // 当存在相等的值时，在相等值的前一个位置插入
        if (nums[mid] >= target) {
            return searchInsert(nums, start, mid, target);
        } else {
            return searchInsert(nums, mid + 1, end, target);
        }
    }

}
