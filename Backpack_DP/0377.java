class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] ans = new int[target + 1];
        ans[0] = 1;
        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                ans[i] += ans[i - num];
            }
        }
        return ans[target];
    }
}