class Solution {
    // 暴力循环，超时
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                int length = height[i] > height[j] ? height[j] : height[i];
                int newArea = length * (j - i);
                if (newArea > area) {
                    area = newArea;
                }
                if (height[i] <= height[j]) {
                    break;
                }
            }
        }
        return area;
    }
}
