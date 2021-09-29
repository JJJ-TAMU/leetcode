class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        char[] cs = s.toCharArray();

        int lo = 0;
        while (lo < cs.length - 2) {
            int hi = getGroupEnd(cs, lo);
            if (hi - lo + 1 >= 3) {
                ans.add(List.of(lo, hi));
            }
            lo = hi + 1;
        }
        return ans;
    }

    private static int getGroupEnd(char[] cs, int lo) {
        char ch = cs[lo++];
        while (lo < cs.length && cs[lo] == ch) {
            lo++;
        }
        return lo - 1;
    }
}