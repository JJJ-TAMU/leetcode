class Solution {
	private static final char EMPTY = '.';
	private static final int N = 9;
	private boolean[][] rows;
	private boolean[][] cols;
	private boolean[][] chunks;

	private static final char BASE = '0';

    public void solveSudoku(char[][] board) {
    	rows = new boolean[N][N + 1];
    	cols = new boolean[N][N + 1];
    	chunks = new boolean[N][N + 1];
    	List<int[]> unfilled = new ArrayList<>();

    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (board[i][j] == EMPTY) {
    				// into list
    				unfilled.add(new int[] {i, j});
    				continue;
    			}
    			int val = board[i][j] - BASE;
    			rows[i][val] = true;
    			cols[j][val] = true;
    			chunks[getChunkIdx(i, j)][val] = true;
    		}
    	}
    	dfs(board, unfilled, 0);
    }

    private boolean dfs(char[][] board, List<int[]> unfilled, int index) {
    	if (index == unfilled.size()) {	return true;	}
    	int[] coor = unfilled.get(index);
    	int i = coor[0], j = coor[1], c = getChunkIdx(i, j);
    	for (int val = 1; val <= 9; val++) {
    		if (!(rows[i][val] || cols[j][val] || chunks[c][val])) {
    			rows[i][val] = true; cols[j][val] = true; chunks[c][val] = true;
    			board[i][j] = (char)(val + BASE);
    			if (dfs(board, unfilled, index + 1)) {	return true;	}
    			rows[i][val] = false; cols[j][val] = false; chunks[c][val] = false;
    		}
    	}
    	return false;
    }

    private static int getChunkIdx(int row, int col) {
    	return row / 3 * 3 + col / 3;
    }
}