class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 1; i <= nums.length; i++) {
            ans ^= i;
        }
        return ans;
    }
}


class Solution {
    public int missingNumber(int[] nums) {
        // move each number into its correct position
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] < n && nums[i] != i) {
                int num = nums[i];
                swap(nums, i, num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) { return i;   }
        }
        return n;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }
}