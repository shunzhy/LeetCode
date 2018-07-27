package com.shun.java.LeetCode;

/**
 * Find First and Last Position of Element in Sorted Array
 * @author zhengyingshun
 * @date 2018-07-27 16:10
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * runtime complexity must be in the order of O(log n)
     * @Author zhengyingshun
     * @Date 2018/7/27 16:17
     */
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int first = getFirstPosition(nums, 0, nums.length - 1, target);
        if (first != -1) {
            int last = getLastPosition(nums, first, nums.length - 1, target);
            result[0] = first;
            result[1] = last;
        }
        
        return result;
    }

    /**
     * 获取第一个值
     * @Author zhengyingshun
     * @Date 2018/7/27 16:20
     */
    public int getFirstPosition(int[] nums, int start, int end, int target) {
        if (nums[start] == target) {
            return start;
        }
        int mid = (start + end) / 2;
        if (start >= end) {
            return -1;
        }
        // 因为要获取第一个为目标值的位置，所以当nums[mid]>=target时，就需进入前半段进行遍历
        if (nums[mid] >= target) {
            return getFirstPosition(nums, start, mid, target);
        } else {
            return getFirstPosition(nums, mid + 1, end, target);
        }
    }

    /**
     * 获取最后一个值
     * @Author zhengyingshun
     * @Date 2018/7/27 16:20
     */
    public int getLastPosition(int[] nums, int start, int end, int target) {
        if (nums[end] == target) {
            return end;
        }
        int mid = (start + end + 1) / 2;
        if (start >= end) {
            return -1;
        }
        // 同上，因为进入后半段遍历时，需要将mid位置也加入后半段遍历，所以为防数组溢出，mid = (start + end + 1) / 2;
        if (nums[mid] <= target) {
            return getLastPosition(nums, mid, end, target);
        } else {
            return getLastPosition(nums, start, mid - 1, target);
        }
    }


}
