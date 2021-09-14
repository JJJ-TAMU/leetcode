class Solution {
    public int search(int[] nums, int target) {
    	// Corner case, null or 0-length array
        if (nums == null || nums.length == 0) {	return -1;	}

        int n = nums.length;
        // Step 1: Check whether there was rotation
        
        // Case 1: [0, n-1] sorted, means the array is sorted
        if (nums[n - 1] >= nums[0]) {	return binarySearch(nums, 0, n - 1, target);	}
        
        // Case 2: rotation happened, find the rotation index
        int rotationIdx = findRotationIdx(nums);

        // [0, rotationIdx - 1] is sorted, [rotationIdx, n - 1] is sorted
        // Step 2: search in two ranges
        int index = binarySearch(nums, 0, rotationIdx - 1, target);
        return index == -1 ? binarySearch(nums, rotationIdx, n - 1, target) : index;
    }

    // returns the rotation index of the rotated array
    private static int findRotationIdx(int[] nums) {
    	int lo = 0, hi = nums.length - 1;
    	// loop invariant: lo < hi and nums[lo] > nums[hi], so rotation index always >= hi
    	while (lo < hi) {
    		if (lo == hi - 1) {		return hi;		}
    		int mi = lo + (hi - lo) / 2;
    		if (nums[mi] >= nums[lo]) {		lo = mi;	}
    		else {	hi = mi;	}
    	}
    	return -1;
    }

    // returns the index of target in sorted range [lo, hi] of nums, -1 if target does nort present here
    private static int binarySearch(int[] nums, int lo, int hi, int target) {
    	while (lo <= hi) {
    		int mi = lo + (hi - lo) / 2;
    		int cmp = Integer.compare(target, nums[mi]);
    		if (cmp < 0) 	  {		hi = mi - 1;	}
    		else if (cmp > 0) {		lo = mi + 1;	}
    		else 			  {		return mi;		}
    	}
    	return -1;
    }
}