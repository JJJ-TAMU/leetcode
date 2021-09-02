class Solution {
    private static final int EMPTY = 0;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, visited, start, destination);
    }

    private static boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] dest) {
        if (start[0] == dest[0] && start[1] == dest[1]) {    return true;    }
        
        int m = maze.length, n = maze[0].length;
        int x = start[0], y = start[1];
        visited[x][y] = true;

        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < n && maze[x][r] == EMPTY) {
            r++;
        }
        r--;
        if (!visited[x][r] &&dfs(maze, visited, new int[]{x, r}, dest)) {
            return true;
        }
        while (l >= 0 && maze[x][l] == EMPTY) {
            l--;
        }
        l++;
        if (!visited[x][l] && dfs(maze, visited, new int[] {x, l}, dest)) {
            return true;
        }
        while (u >= 0 && maze[u][y] == EMPTY) {
            u--;
        }
        u++;
        if (!visited[u][y] && dfs(maze, visited, new int[]{u, y}, dest)) {
            return true;
        }
        while (d < m && maze[d][y] == EMPTY) {
            d++;
        }
        d--;
        if (!visited[d][y] && dfs(maze, visited, new int[]{d, y}, dest)) {
            return true;
        }
        return false;
    }
}