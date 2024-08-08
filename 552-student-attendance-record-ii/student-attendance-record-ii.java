class Solution {
    int mod = 1000000007;
    int[][][] dp;
    public int checkRecord(int n) {
      dp = new int[n + 1][3][2];
      for(int[][] matrix : dp){
        for(int[] row : matrix){
          Arrays.fill(row , -1);
        }
      }
      return solve(n , 2 , 1); 
    }

    private int solve( int n , int late , int abs){
      if(n <= 0){
        return 1;
      }

      if(dp[n][late][abs] != -1) return dp[n][late][abs];

      int total = 0;
      total = solve(n-1 , 2 , abs);
      total %= mod;
      if(late > 0){
        total += solve(n-1 , late-1 , abs);
        total %= mod;
      }

      if(abs > 0){
        total += solve(n-1 , 2 , abs - 1);
        total %= mod;
      }

      return dp[n][late][abs] = total;
    }
}