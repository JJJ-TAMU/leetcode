class Solution {
    // Mark for island and water
    private static final char ISLAND = '1';
    private static final char WATER = '0';

    // Four possible directions
    private static final int[][] DIRS = {
        {-1,  0}, { 1, 0}, {0, -1}, {0, 1}
    };

    public int numIslands(char[][] grid) {
        int nIslands = 0;

        // Iterate over each grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ISLAND) {
                    nIslands++;
                    // Visit this island and mark it as visited
                    bfs(grid, i, j);
                }
            }
        }        
        return nIslands;
    }

    private static void bfs(char[][] grid, int i, int j) {
        grid[i][j] = WATER;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            for (int[] dir : DIRS) {
                int nextI = coor[0] + dir[0], nextJ = coor[1] + dir[1];
                if (valid(grid, nextI, nextJ) && grid[nextI][nextJ] == ISLAND) {
                    grid[nextI][nextJ] = WATER;
                    queue.offer(new int[] {nextI, nextJ});
                }
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = WATER;
        // dfs visit four neighbors
        for (int[] dir : DIRS) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (valid(grid, nextI, nextJ) && grid[nextI][nextJ] == ISLAND) {
                dfs(grid, nextI, nextJ);
            }
        }
    }

    private static boolean valid(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}