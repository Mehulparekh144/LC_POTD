class Solution {
  public int minSteps(int n) {
    if (n == 1)
      return 0;
    int[][] dp = new int[n + 1][n + 1];
    for (int[] row : dp)
      Arrays.fill(row, (int) 1e9);

    dp[1][0] = 0;
    for (int current = 1; current <= n; current++) {
      for (int clipboard = 0; clipboard <= current; clipboard++) {
        // Copy All
        if (current + current <= n) {
          dp[current + current][current] = Math.min(dp[current + current][current], dp[current][clipboard] + 2);
        }
        // Paste
        if (current + clipboard <= n) {
          dp[current + clipboard][clipboard] = Math.min(dp[current + clipboard][clipboard], dp[current][clipboard] + 1);
        }
      }
    }

    int result = Integer.MAX_VALUE;
    for (int clipboard = 1; clipboard <= n; clipboard++) {
      result = Math.min(result, dp[n][clipboard]);
    }

    return result;
  }

}