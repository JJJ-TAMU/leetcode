class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] curr = new int[k];

        backtrack(ans, curr, 0, 1, k, n);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int[] nums, int index, int val, int k, int target) {
        if (k == 0) {
            if (target == 0) {
                ans.add(arrayToList(nums));
            }
            return;
        }
        if (!validate(val, k, target)) {
            return;
        }
        for (int i = val; i <= 9 - k + 1; i++) {
            nums[index] = i;
            backtrack(ans, nums, index + 1, i + 1, k - 1, target - nums[index]);
        }
    }

    private static boolean validate(int first, int k, int target) {
        int low = (first + first + k - 1) * k / 2;
        int high = (9 + 9 - k + 1) * k / 2;
        return target >= low && target <= high;
    }

    private static List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {  list.add(num);  }
        return list;
    }
}