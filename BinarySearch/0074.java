class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {   return false;   }
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int row = mi / n, col = mi % n;
            int cmp = Integer.compare(target, matrix[row][col]);

            if (cmp < 0) {  hi = mi - 1;    }
            else if (cmp > 0) { lo = mi + 1;    }
            else {  return true;    }
        }
        return false;
    }
}