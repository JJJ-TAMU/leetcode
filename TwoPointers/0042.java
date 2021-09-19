class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int lo = 0, hi = height.length - 1;

        int water = 0;
        while (lo <= hi) {
            // left side is bottle neck
            if (leftMax <= rightMax) {
                if (leftMax <= height[lo]) {
                    leftMax = height[lo];
                } else {
                    water += leftMax - height[lo];
                }
                lo++;
            } else {
                if (rightMax <= height[hi]) {
                    rightMax = height[hi];
                } else {
                    water += rightMax - height[hi];
                }
                hi--;
            }
        }
        return water;
    }
}