class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int lo = 0, hi = height.length - 1;

        while (lo < hi) {
            int area = Math.min(height[lo], height[hi]) * (hi - lo);
            max = Math.max(max, area);
            if (height[lo] <= height[hi]) { lo++;   }
            else {  hi--;   }
        }
        return max;
    }
}