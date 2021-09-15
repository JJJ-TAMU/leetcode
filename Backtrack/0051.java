class Solution {
    private static final char EMPTY = '.';
    private static final char QUEEN = 'Q';

    private boolean[] cols;
    private boolean[] diagnols;
    private boolean[] antiDiagnols;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        cols = new boolean[n];
        diagnols = new boolean[2 * n - 1]; 
        antiDiagnols = new boolean[2 * n - 1];
        char[][] board = generateBoard(n);

        backtrack(ans, board, 0);

        return ans;
    }

    private void backtrack(List<List<String>> ans, char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            ans.add(boardToString(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            int col = i, d = i - row + n - 1, ad = i + row;
            if (!(cols[col] || diagnols[d] || antiDiagnols[ad])) {
                cols[i] = true;
                diagnols[d] = true;
                antiDiagnols[ad] = true;
                board[row][i] = QUEEN;
                backtrack(ans, board, row + 1);
                cols[i] = false;
                diagnols[d] = false;
                antiDiagnols[ad] = false;
                board[row][i] = EMPTY;
            }
        }
    }

    private static List<String> boardToString(char[][] board) {
        int n = board.length;
        List<String> ans = new ArrayList<>(n);
        for (char[] row : board) {
            ans.add(String.valueOf(row));
        }
        return ans;
    }

    private static char[][] generateBoard(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
        return board;
    }
}