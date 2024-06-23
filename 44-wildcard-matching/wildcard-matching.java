class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(m - 1, n - 1, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0) {
            while (j >= 0 && p.charAt(j) == '*') {
                j--;
            }

            return j < 0;
        }

        if (j < 0) {
            return false;
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = solve(i - 1, j - 1, s, p) ? 1 : 0;

        }

        else {
            if (p.charAt(j) == '*') {
                dp[i][j] = (solve(i - 1, j, s, p) || solve(i, j - 1, s, p) ? 1 : 0);
            }
        }

        return dp[i][j] == 1;
    }
}