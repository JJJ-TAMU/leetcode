class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(ans, curr, nums, 0);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        backtrack(ans, curr, nums, index + 1);
        curr.add(nums[index]);
        backtrack(ans, curr, nums, index + 1);
        curr.remove(curr.size() - 1);
    }
}