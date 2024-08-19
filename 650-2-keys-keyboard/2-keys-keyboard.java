class Solution {
  int[][] dp;
    public int minSteps(int n) {
      if(n == 1) return 0;
      dp = new int[n+1][n+1];
      for(int[] row : dp) Arrays.fill(row , -1);
      return 1 + solve(1 , 1 , n);
    }

    private int solve(int current , int clipboard , int n){
      if(current == n){
        return 0;
      }

      if(current > n) return (int) 1e9;

      if(dp[current][clipboard] != -1) return dp[current][clipboard];

      int copyAndPaste = 2 + solve(current*2 , current , n);
      int paste = 1 + solve(current + clipboard , clipboard , n );
      
      return dp[current][clipboard]= Math.min(copyAndPaste , paste);
    }
}