class Solution {
    // Define two types of grids
    private static final char WATER = '0';
    private static final char LAND = '1';

    // Define four directions
    private static final int[][] DIRS = {
        {0, -1}, {0, 1}, // left, right
        {-1, 0}, {1 ,0}  // up down
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    counter++;
                    bfs(grid, i, j);
                } 
            }
        }

        return counter;
    }

    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = WATER;
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            for (int[] dir : DIRS) {
                int newI = coor[0] + dir[0];
                int newJ = coor[1] + dir[1];
                if (validate(grid, newI, newJ) && grid[newI][newJ] == LAND) {
                    grid[newI][newJ] = WATER;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }
    }

    private static boolean validate(char[][] grid, int i, int j) {
        int rows = grid.length, cols = grid[0].length;
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}