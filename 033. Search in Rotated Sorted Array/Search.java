package com.shun.java.LeetCode;

/**
 * Search in Rotated Sorted Array
 * @author zhengyingshun
 * @date 2018-07-27 11:05
 */
public class SearchInRotatedSortedArray {

    /**
     * Search in Rotated Sorted Array
     * runtime complexity must be in the order of O(log n)
     * @Author zhengyingshun
     * @Date 2018/7/27 11:05
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        if (start >= end - 1) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        /**
         * 1、如果nums[start] < nums [mid]，则start到mid为有序的
         * 2、如果nums[mid] < nums [end]，则mid到end为有序的
         * 3、如果条件1 2都不满足，则目标值必定处于乱序的那段数组中
         */
        if ((nums[start] < nums [mid] && target > nums[start] && target < nums[mid])) {
            return search(nums, start, mid, target);
        } else if ((nums[mid] < nums [end] && target > nums[mid] && target < nums[end])) {
            return search(nums, mid + 1, end, target);
        } else if (nums[start] >= nums[mid]) {
            return search(nums, start, mid, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }

}
