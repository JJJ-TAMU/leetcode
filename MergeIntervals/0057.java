class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 1: find all intervals ends before the new one begins
        //    = number of intervals with end < newInterval.start
        int endsBefore = rank(intervals, newInterval[0], 1);

        // Step 2: find all intervals starts after the new one ends
        //    = number of intervals with start > newInterval.end
        int startsAfter = rank(intervals, newInterval[1] + 1, 0);

        // Step 3: merge all other intervals with the new one
        // now all intervals in range[endsBefore, startsAfter) overlap with the new one
        for (int i = endsBefore; i < startsAfter; i++) {
            merge(newInterval, intervals[i]);
        }
        
        // Step 4: before + merged + after = new list
        // total = old size - merged with new one + new one
        int total = intervals.length - (startsAfter - endsBefore) + 1;
        int[][] newIntervals = new int[total][];

        // Step 4.1: copy those ends before
        System.arraycopy(intervals, 0, newIntervals, 0, endsBefore);
        // Step 4.2: copy the merged one
        newIntervals[endsBefore] = newInterval;
        // Step 4.3: copy those starts after
        System.arraycopy(intervals, startsAfter, newIntervals, endsBefore + 1, intervals.length - startsAfter);

        return newIntervals;
    }

    private static void merge(int[] newOne, int[] oldOne) {
        newOne[0] = Math.min(newOne[0], oldOne[0]);
        newOne[1] = Math.max(newOne[1], oldOne[1]);
    }

    private static int rank(int[][] intervals, int target, int index) {
        int lo = 0, hi = intervals.length - 1;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int value = intervals[mi][index];
            if (value < target) {   lo = mi + 1;    }
            else {  hi = mi - 1;    }
        }
        return lo;
    }

}