class Solution {
  private static int MOD = (int) 1e9 + 7;
  private long[][] dp;
  public int kInversePairs(int n, int k) {
    dp = new long[n+1][k+1];

    for(int i = 1 ; i <= n ; i++){
      dp[i][0] = 1L;
    }

    for(int i = 1 ; i <= n ; i++){
      for(int k1 = 1 ; k1 <= k ; k1++){
        long res = 0;

        for(int j = 0 ; j <= Math.min(i-1 , k1) ; j++){
          dp[i][k1] += dp[i-1][k1-j];
          dp[i][k1] %= MOD;
        }
      }
    }

    return (int) dp[n][k];
  }

  // private long solve(int n, int k) {
  //   if (k == 0)
  //     return 1;
  //   if(n == 0) return 0;

  //   if(dp[n][k] != -1) return dp[n][k];

  //   long res = 0;

  //   for(int i = 0 ; i <= Math.min(n-1 , k) ; i++){
  //     res += solve(n-1 , k-i);
  //     res %= MOD;
  //   }

  //   return dp[n][k] = res;

  // }
}