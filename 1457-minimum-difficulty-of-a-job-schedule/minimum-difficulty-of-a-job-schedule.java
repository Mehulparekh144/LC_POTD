class Solution {

  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) {
      return -1;
    }

    int[][] dp = new int[n + 1][d + 1];

    for (int i = 0; i <= n; i++) {
      for (int d1 = 0; d1 <= d; d1++) {
        dp[i][d1] = (int) 1e9;
      }
    }

    dp[n][0] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int d1 = 1; d1 <= d; d1++) {
        int curr = 0;
        int res = (int) 1e9;

        for (int j = i; j < n; j++) {
          curr = Math.max(curr, jobDifficulty[j]);
          res = Math.min(
              res,
              curr + dp[j + 1][d1 - 1]);
        }

        dp[i][d1] = res;
      }
    }

    return dp[0][d] == (int) 1e9 ? -1 : dp[0][d];
  }

}