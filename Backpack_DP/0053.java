class Solution {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int max = nums[0];
        for (int num : nums) {
        	prev = prev > 0 ? prev + num : num;
        	max = Math.max(max, prev);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1);        
    }

    private static final int maxSubArray(int[] nums, int lo, int hi) {
    	if (lo > hi) {	return Integer.MIN_VALUE;	}
    	int mi = lo + (hi - lo) / 2;
    	// leftMax and rightMax are the maximum which do not include the middle element
    	int leftMax = maxSubArray(nums, lo, mi - 1);
    	int rightMax = maxSubArray(nums, mi + 1, hi);
    	// middleMax is the maximum which includes the middle element
    	int lMax = 0;
    	int runningSum = 0;
    	for (int i = mi - 1; i >= lo; i--) {
    		runningSum += nums[i];
    		lMax = Math.max(lMax, runningSum);
    	}

    	int rMax = 0;
    	runningSum = 0;
    	for (int i = mi + 1; i <= hi; i++) {
    		runningSum += nums[i];
    		rMax = Math.max(rMax, runningSum);
    	}
    	int middleMax = lMax + nums[mi] + rMax;
    	return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}