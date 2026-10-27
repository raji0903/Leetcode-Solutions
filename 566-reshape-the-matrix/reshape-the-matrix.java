class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        // If the total number of elements does not match, return original matrix
        if (m * n != r * c) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        for (int k = 0; k < m * n; k++) {
            res[k / c][k % c] = mat[k / n][k % n];
        }
        
        return res;
    }
}