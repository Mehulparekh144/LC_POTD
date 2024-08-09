class Solution {
  private static final int MOD = (int) 1e9 + 7;
  private int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
       dp = new int[n+1][target + 1];
       for(int[] row : dp) Arrays.fill(row , -1);
       return solve(n , k , target); 
    }

    private int solve(int n , int k , int target){
      if(target < 0) return 0;
      if(n < 0) return 0;

      if(n == 0){
        return target == 0 ? 1 : 0;
      }

      if(dp[n][target] != -1) return dp[n][target];

      int ways = 0;

      for(int i = 1 ; i <= k ; i++){
          ways = (ways + solve(n-1 , k , target - i))%MOD;

      }

      return dp[n][target] = ways;
    }
}