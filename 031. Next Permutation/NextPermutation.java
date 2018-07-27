package com.shun.java.LeetCode;

import java.util.Arrays;

/**
 * Next Permutation
 * @author zhengyingshun
 * @date 2018-03-27 16:03
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // 从后往前遍历，获取存在的第一个比后面任一一个数小的数所在的位置
        int minBigPosition = 0; //分割位置后的序列中大于nums[seg]的最小数的位置
        int max = 0;
        int seg = -1; //记录分割的位置
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((nums[i] > max)) {
                max = nums[i];
                minBigPosition = i;
            }
            if (nums[i] < max) {
                seg = i;
                break;
            }
        }
        // 表示不存在比当前序列更大的序列
        if (seg == -1) {
            Arrays.sort(nums);
            return;
        }
        int tmp = nums[seg];
        // 当seg分割点开始往后遍历，获取比seg大的最小的数所在的位置
        int changeNum = max; //分割位置后的序列中大于nums[seg]的当前最小数
        for (int i = seg; i < nums.length; i++) {
            if (nums[i] > tmp && nums[i] < changeNum) {
                minBigPosition = i;
                changeNum = nums[i];
            }
        }
        // 交换seg与minBigPosition位置
        nums[seg] = changeNum;
        nums[minBigPosition] = tmp;
        // 将seg后的序列按升序重新排序
        Arrays.sort(nums, seg + 1, nums.length);
    }

}
