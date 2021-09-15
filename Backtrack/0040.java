class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, curr, candidates, 0, 0, target);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int index, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index == candidates.length || sum + candidates[index] > target) {
            return;
        }
        curr.add(candidates[index]);
        backtrack(ans, curr, candidates, index + 1, sum + candidates[index], target);
        curr.remove(curr.size() - 1);
        int j = index + 1;
        while (j < candidates.length && candidates[index] == candidates[j]) {
            j++;
        }
        backtrack(ans, curr, candidates, j, sum, target);
    }
}