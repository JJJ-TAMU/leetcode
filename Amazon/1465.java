class Solution {
    private static final int DIVISOR = 1_000_000_007;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int height = getMaxCut(horizontalCuts, 0, h);
        int width = getMaxCut(verticalCuts, 0, w);
        return (int)((long)height * width % DIVISOR);
    }

    private static final int getMaxCut(int[] cuts, int lo, int hi) {
        int max = 0;
        int prev = lo;
        for (int cut : cuts) {
            max = Math.max(cut - prev, max);
            prev = cut;
        }
        max = Math.max(hi - prev, max);
        return max;
    }
}