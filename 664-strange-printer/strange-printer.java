class Solution {
  int[][] dp;
  public int strangePrinter(String s) {
    int n = s.length();
    dp = new int[n][n];
    for(int[] row : dp) Arrays.fill(row , -1);
    return solve(0, n - 1, s);
  }

  private int solve(int i, int j, String s) {
    if (i > j)
      return 0;

    if(dp[i][j] != -1) return dp[i][j];

    int res = 1 + solve(i + 1, j, s);

    for (int k = i + 1; k <= j; k++) {
      if (s.charAt(i) == s.charAt(k)) {
        res = Math.min(
            res,
            solve(i, k - 1, s) +
            solve(k + 1, j, s));
      }
    }

    return dp[i][j] = res;

  }
}