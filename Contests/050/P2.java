class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int counter = 0;
            query[2] *= query[2];
            for (int[] point : points) {
                if (inCircle(point, query)) {
                    counter++;
                }
            }
            ans[i] = counter;
        }
        return ans;
    }

    private static boolean inCircle(int[] point, int[] circle) {
        int x = point[0] - circle[0];
        int y = point[1] - circle[1];
        return x *x + y * y <= circle[2];
    }
}