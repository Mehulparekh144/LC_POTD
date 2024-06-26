class Solution {
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxi = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxi = Math.max(maxi, solve(i, j, matrix));
            }
        }

        return maxi;

    }

    private int solve(int i, int j, int[][] matrix) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int[] dirX = { 1, 0, -1, 0 };
        int[] dirY = { 0, -1, 0, 1 };
        int maxi = 1;
        for (int k = 0; k < dirX.length; k++) {
            int x = i + dirX[k];
            int y = j + dirY[k];

            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                int length = 1 + solve(x, y, matrix);
                maxi = Math.max(maxi, length);
            }
        }

        return dp[i][j] = maxi;
    }

}