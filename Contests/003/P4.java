class Solution {
    private static final int[][] DIRS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    private int m;
    private int n;
    private static final int FILL = -1;

    public int maximumMinimumPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {
        int old = grid[i][j];
        if (i == m - 1 && j == n - 1) {
            return old;
        }

        grid[i][j] = FILL;
        int max = 0;
        for (int[] dir : DIRS) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (validate(nextI, nextJ) && grid[nextI][nextJ] != FILL) {
                max = Math.max(max, dfs(grid, nextI, nextJ));
            }
        }

        grid[i][j] = old;
        return Math.min(old, max);
    }

    private boolean validate(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}