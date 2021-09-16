class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        List<Integer> curr = new ArrayList<>();

        backtrack(ans, curr, nums, 0);

        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(ans, curr, nums, index + 1);
        curr.remove(curr.size() - 1);

        int j = index + 1;
        while (j < nums.length && nums[j] == nums[index]) {
            j++;
        }
        backtrack(ans, curr, nums, j);
    }
}