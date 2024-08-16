class Solution {
    int m;
    int n;
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
      m = grid.length;
      n = grid[0].length;

      dp = new int[m][n];
      for(int[] row : dp) Arrays.fill(row , -1);

      int res = Integer.MAX_VALUE;
      for(int j = 0 ; j < n ; j++){
        res = Math.min(
          res ,
          solve(0 , j , grid)
        );
      }

      return res;
    }

    private int solve(int i , int j , int[][] grid){
      if(i == m-1){
        return grid[i][j];
      }

      if(dp[i][j] != -1) return dp[i][j];

      int res = grid[i][j];
      int min = Integer.MAX_VALUE;
      for(int j1 = 0 ; j1 < n ; j1++){
        if(j == j1) continue;
        min = Math.min(min , solve(i+1 , j1 , grid));
      }

      res += min;
      return dp[i][j] = res;
    }
}