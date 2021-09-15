class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(nums.length);
        for (int num : nums) {  curr.add(num);  }

        backtrack(ans, curr, 0);
        return ans;        
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> curr, int index) {
        if (index == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < curr.size(); i++) {
            swap(curr, index, i);
            backtrack(ans, curr, index + 1);
            swap(curr, index, i);
        }
    }

    private static void swap(List<Integer> l, int i, int j) {
        int tmp = l.get(i); l.set(i, l.get(j)); l.set(j, tmp);
    }
}