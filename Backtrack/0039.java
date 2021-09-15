class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), candidates, 0, 0, target);    
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int index, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index == candidates.length || sum + candidates[index] > target) {
            return;
        }
        dfs(ans, curr, candidates, index + 1, sum, target);
        curr.add(candidates[index]);
        dfs(ans, curr, candidates, index, sum + candidates[index], target);
        curr.remove(curr.size() - 1);

    }
}