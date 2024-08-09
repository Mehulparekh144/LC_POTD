class Solution {
  int m;
  int n;
  int l;
  boolean[][] dp;

  public boolean isInterleave(String s1, String s2, String s3) {
    m = s1.length();
    n = s2.length();
    l = s3.length();

    if(m + n != l) return false;

    dp = new boolean[m + 1][n + 1];

    dp[m][n] = true;


    for (int i = m; i >= 0; i--) {
      for (int j = n; j >= 0; j--) {

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

  // private boolean dfs(int i, int j, int k, String s1, String s2, String s3) {

  //   if (i == m && j == n && k == l)
  //     return true;

  //   if (k >= l)
  //     return false;

  //   if (dp[i][j][k] != -1)
  //     return dp[i][j][k] == 1;

  //   dp[i][j][k] = res == true ? 1 : 0;

  //   return res;
  // }
}