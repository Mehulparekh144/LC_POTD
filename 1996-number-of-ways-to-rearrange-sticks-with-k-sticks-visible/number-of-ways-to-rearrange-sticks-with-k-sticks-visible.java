/**
 * Pick largest candle 3 so now other sub problem will be (n-1)* dfs why n-1
 * because since 3 is largest all others will be visible
 */
class Solution {
  private final static int MOD = (int) 1e9 + 7;
  public int rearrangeSticks(int n, int k) {
    long[][] dp = new long[n + 1][k + 1];

    dp[1][1] = 1;

    for(int i = 2 ; i <= n ; i++){
      for(int j = 1 ; j <= k ; j++){
        dp[i][j] = dp[i-1][j-1] + (i-1)*dp[i-1][j];
        dp[i][j] %= MOD;
      }
    }

    return (int) dp[n][k];
  }
}