class Solution {
    int m;
    int n;
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
      m = grid.length;
      n = grid[0].length;

      dp = new int[m][n];

      for(int j = 0 ; j < n ; j++){
        dp[m-1][j] = grid[m-1][j];
      }

      for(int i = m-2 ; i >= 0 ; i--){
        for(int j = n-1 ; j >= 0 ; j--){
          int res = grid[i][j];
          int min = Integer.MAX_VALUE;

          for(int j1 = 0 ; j1 < n ; j1++){
            if(j == j1) continue;
            min = Math.min(min , dp[i+1][j1]);
          }

          res += min;
          dp[i][j] = res;
        }
      }

      int res = Integer.MAX_VALUE;
      for(int j = 0 ; j < n ; j++){
        res = Math.min(
          res ,
          dp[0][j]
        );
      }

      return res;
    }

}