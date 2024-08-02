class Solution {
    int[] dp;
    public int numSquares(int n) {
      dp = new int[n+1];
      Arrays.fill(dp , -1);
      return solve(n);
    }

    private int solve(int n){
      if(n <= 0) return 0;
      if(dp[n] != -1) return dp[n];

      int min = Integer.MAX_VALUE;

      for(int i = 1 ; i*i <= n ; i++){
          int res = 1 + solve(n - i*i);
          min = Math.min(res , min);
      }

      return dp[n] = min;
    }

}