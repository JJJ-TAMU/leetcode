class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        /*
        int sIdx = 0;
        int rooms = 0;
        for (int eIdx = 0; eIdx < n; eIdx++) {
            while (sIdx < n && start[sIdx] < end[eIdx]) {
                sIdx++;
            }
            // sIdx represents number of events started
            // eIdx represents number of events ended
            rooms = Math.max(rooms, sIdx - eIdx);
        }*/
        int eIdx = 0;
        int rooms = 0;
        for (int sIdx = 0; sIdx < n; sIdx++) {
            while (eIdx < n && end[eIdx] <= start[sIdx]) {
                eIdx++;
            }
            rooms = Math.max(rooms, sIdx + 1 - eIdx);
        }
        return rooms;
    }
}