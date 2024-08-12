class Solution {
  private final static int MOD = (int) 1e9 + 7;
  Long[][] dp;
    public int rearrangeSticks(int n, int k) {
      dp = new Long[n+1][k + 1];
      return (int) solve(n , k );
    }

    private long solve(int n , int k){
      if(n == k) {
        return 1;
      }
      if(n == 0 || k == 0){
        return 0;
      }

      if(dp[n][k] != null) return dp[n][k];

      long ways = solve(n-1 , k-1) + (n-1)* solve(n-1 , k);

      dp[n][k] = ways%MOD;

      return ways%MOD;
    }
}