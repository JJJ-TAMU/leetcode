class Solution {
    private static final int OFF_SET = 1000;
    private static final int N = 2001;

    public int findTargetSumWays(int[] nums, int target) {
        int[] prev = new int[N];
        prev[OFF_SET] = 1;
        int[] curr = new int[N];
        int lo = OFF_SET, hi = OFF_SET;
        for (int num : nums) {
            int currLo = lo, currHi = hi;
            for (int i = lo; i <= hi; i++) {
                if (prev[i] != 0) {
                    curr[i + num] += prev[i];
                    curr[i - num] += prev[i];
                    currLo = Math.min(currLo, i - num);
                    currHi = Math.max(currHi, i + num);
                }
            }
            lo = currLo;
            hi = currHi;
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            Arrays.fill(curr, 0);
        }
        return prev[target + OFF_SET];
    }
}