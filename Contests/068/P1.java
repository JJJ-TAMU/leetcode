class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;    
        for (int r = 0; r < m; r++) {
            if (!isDiagonalEqual(matrix, r, 0)) {
                return false;
            }
        }
        for (int c = 1; c < n; c++) {
            if (!isDiagonalEqual(matrix, 0, c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDiagonalEqual(int[][] matrix, int r, int c) {
        int m = matrix.length, n = matrix[0].length;
        int target = matrix[r][c];
        while (r < m && c < n) {
            if (matrix[r++][c++] != target) {
                return false;
            }
        }
        return true;
    }

}