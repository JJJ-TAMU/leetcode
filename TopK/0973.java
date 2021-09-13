class Solution {
    private static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int distance; // be care of overflow issues
        public Point(int x, int y) {
            this.x = x; this.y = y; this.distance = x * x + y * y;
        }
        @Override
        public int compareTo(Point other) { return Integer.compare(distance, other.distance);   }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            ps[i] = new Point(point[0], point[1]);
        }

        quickSelect(ps, 0, n - 1, k - 1);

        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = new int[] {ps[i].x, ps[i].y};
        }
        return ans;
    }

    private static void quickSelect(Point[] ps, int lo, int hi, int k) {
        if (lo >= hi) { return; }
        Point pivot = ps[lo];
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            int cmp = ps[i].compareTo(pivot);
            if (cmp < 0) {  swap(ps, lt++, i++);    }
            else if (cmp == 0) {    i++;    }
            else {  swap(ps, gt--, i);  }
        }
        if (k < lt) {   quickSelect(ps, lo, lt - 1, k); }
        if (k > gt) {   quickSelect(ps, gt + 1, hi, k); }
    }

    private static void swap(Point[] ps, int i, int j) {
        Point tmp = ps[i]; ps[i] = ps[j]; ps[j] = tmp;
    }
}