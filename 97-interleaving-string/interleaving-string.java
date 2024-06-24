class Solution {
    int m;
    int n;
    int l;

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        l = s3.length();
        if (m + n != l) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                boolean result = false;

                if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i+1][j];
                } 

                if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i][j+1];
                }

            }
        }

        return dp[0][0];
    }

   
}