class Solution {
  private static final int MOD = (int) 1e9 + 7;
  private int[][][] dp;

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    dp = new int[m][n][maxMove + 1];
    for(int[][] mat : dp){
      for(int[] row : mat){
        Arrays.fill(row , -1);
      }
    }
    return solve(startRow, startColumn, m, n, maxMove);
  }

  private int solve(int sr, int sc, int m, int n, int maxMove) {
    if (sr >= m || sc >= n || sr < 0 || sc < 0) {
      return 1;
    }

    if(dp[sr][sc][maxMove] != -1) return dp[sr][sc][maxMove];

    if (maxMove == 0)
      return 0;

    int res = 0;
    res = (res + solve(sr, sc - 1, m, n, maxMove-1)) % MOD;
    res = (res + solve(sr, sc + 1, m, n, maxMove-1)) % MOD;
    res = (res + solve(sr - 1, sc, m, n, maxMove-1)) % MOD;
    res = (res + solve(sr + 1, sc, m, n, maxMove-1)) % MOD;

    return dp[sr][sc][maxMove] = res;

  }
}