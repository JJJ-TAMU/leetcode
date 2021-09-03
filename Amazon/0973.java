class Solution {
    private static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int distance;
        public Point(int x, int y) {
            this.x = x; this.y = y; distance = x * x + y * y;
        }
        @Override
        public int compareTo(Point p) {
            return Integer.compare(distance, p.distance);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new Point(points[i][0], points[i][1]);
        }
        quickSelect(ps, 0, n - 1, k - 1);
        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = new int[] { ps[i].x, ps[i].y};
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
            else if (cmp > 0) { swap(ps, gt--, i);  }
            else {  i++;    }
        }
        if (lt > k) {   quickSelect(ps, lo, lt - 1, k); }
        if (gt < k) {   quickSelect(ps, gt + 1, hi, k); }
    }

    private static void swap(Point[] ps, int i, int j) {
        Point tmp = ps[i]; ps[i] = ps[j]; ps[j] = tmp;
    }
}