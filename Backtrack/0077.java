class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] curr = new int[k];
        backtrack(ans, curr, 0, 1, n);

        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int[] curr, int index, int value, int n) {
        if (index == curr.length) {
            ans.add(arrayToList(curr));
            return;
        }
        int rest = curr.length - index;
        for (int i = value; i <= n - rest + 1; i++) {
            curr[index] = i;
            backtrack(ans, curr, index + 1, i + 1, n);
        }
    }

    private static List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}