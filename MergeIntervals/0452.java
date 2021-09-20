class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2)->Integer.compare(p1[1], p2[1]));
        int n = 0;
        int index = 0;
        while (index < points.length) {
            int end = points[index][1];
            while (index < points.length && points[index][0] <= end) {
                index++;
            }
            n++;
        }
        return n;
    }
}