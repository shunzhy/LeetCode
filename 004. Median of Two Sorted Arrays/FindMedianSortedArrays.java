class Solution {

    // 2018/2/2
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length = nums1.length + nums2.length;
        double median = length / 2d;
        // 空数组处理
        if (nums1.length == 0) {
            j = nums2.length / 2;
            if (length % 2 == 0) {
                return (nums2[j] + nums2[j - 1]) / 2d;
            } else {
                return nums2[j];
            }
        } else if (nums2.length == 0) {
            i = nums1.length / 2;
            if (length % 2 == 0) {
                return (nums1[i] + nums1[i - 1]) / 2d;
            } else {
                return nums1[i];
            }
        }
        // 遍历获取median的位置
        boolean num1Flag = false;
        while (i + j < median) {
            while (i < nums1.length && i + j < median && (j >= nums2.length || nums1[i] <= nums2[j])) {
                i++;
                num1Flag = true;
            }
            while (j < nums2.length && i + j < median && (i >= nums1.length || nums1[i] > nums2[j])) {
                j++;
                num1Flag = false;
            }
        }
        // 判断长度是偶数还是奇数
        if (length % 2 == 0) {
            double result;
            if (num1Flag) {
                result = nums1[i - 1];
            } else {
                result = nums2[j - 1];
            }
            // 判断下一个值出自哪个数组
            if (j >= nums2.length) {
                result += nums1[i];
            } else if (i >= nums1.length) {
                result += nums2[j];
            } else {
                result += nums1[i] > nums2[j] ? nums2[j] : nums1[i];
            }
            return result / 2d;
        } else {
            return num1Flag ? nums1[i - 1] : nums2[j - 1];
        }
    }
}
