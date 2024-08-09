class Solution {
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[] mat = new int[1];
      dp = new int[m][n];

      for(int[] row : dp) Arrays.fill(row , -1);

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          dfs(i , j , mat , matrix);
        }
      }

      return mat[0]*mat[0];
    }

    private int  dfs(int i , int j , int[] mat , char[][] matrix){
      if(i < 0 || j < 0 || matrix[i][j] == '0') return 0;

      if(dp[i][j] != -1) return dp[i][j];

      int up = dfs(i-1 , j , mat , matrix);
      int left = dfs(i , j-1 , mat , matrix);
      int diag = dfs(i-1 , j-1 , mat , matrix);

      int side = Math.min(up , Math.min(left , diag)) + 1;

      mat[0] = Math.max(mat[0] , side);
      return dp[i][j] = side;    
    }
}