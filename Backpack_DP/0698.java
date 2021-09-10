class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k < 2) {    return true;    }
        int sum = sum(nums);
        if (sum % k != 0) {     return false;   }
        int n = nums.length;
        boolean[] used = new boolean[n];
        return dfs(nums, used, 0, 0, sum / k, k - 1);
    }
    
    private static boolean dfs(int[] nums, boolean[] used, int idx, int sum, int target, int groups) {
        if (sum == target) {
            if (--groups == 0) {
                return true;
            }
            sum = 0;
            idx = 0;
        }
        for (int i = idx; i < nums.length; i++) {
            if (!used[i] && sum + nums[i] <= target) {
                used[i] = true;
                if (dfs(nums, used, i + 1, sum + nums[i], target, groups)) {    return true;    }
                used[i] = false;
            }
        }
        return false;
    }
    
    private static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}