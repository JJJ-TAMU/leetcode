class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->Integer.compare(i1[1], i2[1]));

        int keep = 0;
        int end = Integer.MIN_VALUE;

        int index = 0;
        while (true) {
            while (index < intervals.length && intervals[index][0] < end) {
                index++;
            }
            if (index == intervals.length) {
                break;
            }
            keep++;
            end = intervals[index][1];
        }

        return intervals.length - keep;
    }
}