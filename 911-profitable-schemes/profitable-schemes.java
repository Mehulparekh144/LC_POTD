class Solution {
  private int MOD = (int) 1e9 + 7;
  long[][][] dp;

  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    dp = new long[n + 1][group.length + 1][minProfit + 1];
    for(long[][] row : dp){
      for(long[] mat : row){
        Arrays.fill(mat , -1);
      }
    }
    return (int) solve(n, 0, 0, minProfit, group, profit);
  }

  private long solve(int n, int i, int p, int minProfit, int[] group, int[] profit) {
    if (i == group.length || n <= 0) {
      if (p >= minProfit) {
        return 1;
      }
      return 0;
    }

    if(dp[n][i][p] != -1) return dp[n][i][p];

    long np = solve(n, i + 1, p, minProfit, group, profit);

    long pick = 0;
    if (group[i] <= n) {
      pick = solve(n - group[i], i + 1, Math.min(minProfit , p + profit[i] ), minProfit, group, profit);
    }

    return dp[n][i][p] = (np + pick) % MOD;
  }
}