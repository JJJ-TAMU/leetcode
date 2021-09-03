class Solution {
    public int trap(int[] height) {
        // lMax: left side highest bar height
        // rMAX: right side highest bar height
        int lMax = 0, rMax = 0;
        int lo = 0, hi = height.length - 1;
        int water = 0;
        // iterate over the range
        while (lo <= hi) {
            // if left side highest bar is the bottleneck, we should trye to
            // increase it
            if (lMax <= rMax) {
                if (lMax > height[lo]) {
                    water += lMax - height[lo];
                } else {
                    lMax = height[lo];
                }
                lo++;
            } else {
                if (rMax > height[hi]) {
                    water += rMax - height[hi];
                } else {
                    rMax = height[hi];
                }
                hi--;
            }
        }
        return water;
    }
}