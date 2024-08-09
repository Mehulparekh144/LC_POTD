class Solution {
  private static final int MOD = (int) 1e9 + 7;

  public int numRollsToTarget(int n, int k, int target) {
    int[] prev = new int[target + 1];
    int[] curr;

    prev[0] = 1;

    for (int i = 1; i <= n; i++) {
      curr = new int[target + 1];
      for (int t = 0; t <= target; t++) {
        for (int x = 1; x <= k; x++) {
          if(t < x) continue;
          curr[t] = (curr[t] + prev[t - x])%MOD;
        }
      }

      prev = curr.clone();
    }

    return prev[target];
  }

  // private int solve(int n, int k, int target) {
  //   if (target < 0)
  //     return 0;
  //   if (n < 0)
  //     return 0;

  //   if (n == 0) {
  //     return target == 0 ? 1 : 0;
  //   }

  //   if (dp[n][target] != -1)
  //     return dp[n][target];

  //   int ways = 0;

  //   for (int i = 1; i <= k; i++) {
  //     ways = (ways + solve(n - 1, k, target - i)) % MOD;

  //   }

  //   return dp[n][target] = ways;
  // }
}