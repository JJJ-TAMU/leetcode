class Solution {
    public int maxChunksToSorted(int[] arr) {
        int lo = 0;
        int nChunks = 0;
        int n = arr.length;
        while (lo < n) {
            lo = getChunkEnd(arr, lo);
            nChunks++;
        }
        return nChunks;
    }

    private static int getChunkEnd(int[] arr, int lo) {
        int max = arr[lo];
        while (lo <= max) {
            max = Math.max(max, arr[lo]);
            lo++;
        }
        return lo;
    }
}