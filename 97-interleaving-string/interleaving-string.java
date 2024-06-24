class Solution {
    int m;
    int n;
    int l;
    int[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        l = s3.length();
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if (m + n != l) {
            return false;
        }

        return solve(0, 0, s1, s2, s3);
    }

    private boolean solve(int i, int j, String s1, String s2, String s3) {
        if (i == m && j == n ) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
            result = solve(i + 1, j, s1, s2, s3);
        }

        if (result)
            return true;

        if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
            result = solve(i, j + 1, s1, s2, s3);
        }

        dp[i][j] = result ? 1 : 0;

        return result;
    }
}