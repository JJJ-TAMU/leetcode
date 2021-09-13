class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (i1, i2)->Integer.compare(
                matrix[i1[0]][i1[1]],
                matrix[i2[0]][i2[1]]
                )); 
        pq.offer(new int[]{0, 0});
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int[] coor = pq.poll();
            int x = coor[0], y = coor[1];
            ans = matrix[x][y];
            if (x + 1 < m && !visited[x + 1][y]) {
                pq.offer(new int[]{x + 1, y});
                visited[x + 1][y] = true;
            }
            if (y + 1 < n && !visited[x][y + 1]) {
                pq.offer(new int[] {x, y+ 1});
                visited[x][y + 1] = true;
            }
        }

        return ans;
    }

}