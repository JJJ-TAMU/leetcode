class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int cloest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  continue;   }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int cmp = Integer.compare(sum, target);
                if (cmp == 0) { return sum; }
                else if (cmp < 0) {
                    if (target - sum < Math.abs(cloest - target)) {
                        cloest = sum;
                    }
                    j++;
                } else {
                    if (sum - target < Math.abs(cloest - target)) {
                        cloest = sum;
                    }
                    k--;
                }
            }
         }
         return cloest;
    }
}