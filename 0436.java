class Solution {
    private static class Interval implements Comparable<Interval> {
        private int start;
        private int end;
        private int index;
        public Interval(int s, int e, int i) {
            start = s; end = e; index = i;
        }
        @Override
        public int compareTo(Interval i) {
            return Integer.compare(start, i.start);
        }
    }
    public int[] findRightInterval(int[][] intervals) {
        // sort by start, binary search
        int n = intervals.length;
        Interval[] is = new Interval[n];
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            is[i] = new Interval(interval[0], interval[1], i);
        }
        
        Arrays.sort(is);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = rank(is, i, is[i].end);
            if (rank == n) {
                ans[is[i].index] = -1;
            } else {
                ans[is[i].index] = is[rank].index;
            }
        }
        return ans;
    }
    
    private static int rank(Interval[] is, int lo, int target) {
        int hi = is.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (is[mi].start < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }
}