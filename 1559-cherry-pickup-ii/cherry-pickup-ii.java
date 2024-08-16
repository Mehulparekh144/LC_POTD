class Solution {
    int m;
    int n;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n + 1][n + 1];

        for(int[][] mat : dp){
          for(int[] row : mat){
            Arrays.fill(row , -1);
          }
        }
        return solve(0 , 0 , n-1 , grid);
    }

    private int solve(int i , int j1 , int j2 , int[][] grid){
      if(j1 >= n || j1 < 0 || j2 >= n || j2 < 0 ){
        return 0;
      }

      if(i == m-1){
        if(j1 == j2){
          return grid[i][j2];
        }

        return grid[i][j1] + grid[i][j2];
      }

      if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

      int res = grid[i][j1];
      if(j1 != j2){
        res += grid[i][j2];
      }

      int maxCherries = 0;
      for(int j = 1 ; j >= -1 ; j--){
        for(int k = 1 ; k >= -1 ; k--){
          maxCherries = Math.max(maxCherries , solve(i+1 , j1 + j , j2 + k , grid));
        }
      }

      res += maxCherries;

      return dp[i][j1][j2] = res;
    }
}