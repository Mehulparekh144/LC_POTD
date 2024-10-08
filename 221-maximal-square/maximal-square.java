class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int max = 0;
    int[] prev = new int[n];

    for (int i = 0; i < m; i++) {
      int[] curr = new int[n];
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {

          if (i == 0 || j == 0) {
            curr[j] = 1;
          } else {
            int up = prev[j];
            int left = curr[j - 1];
            int diag = prev[j - 1];

            curr[j] = Math.min(up, Math.min(left, diag)) + 1;
          }
          max = Math.max(curr[j], max);
        }
      }

      prev = curr.clone();
    }

    return max * max;
  }

  // private int dfs(int i , int j , int[] mat , char[][] matrix){
  // if(i < 0 || j < 0 || matrix[i][j] == '0') return 0;

  // if(dp[i][j] != -1) return dp[i][j];

  // int up = dfs(i-1 , j , mat , matrix);
  // int left = dfs(i , j-1 , mat , matrix);
  // int diag = dfs(i-1 , j-1 , mat , matrix);

  // int side = Math.min(up , Math.min(left , diag)) + 1;

  // mat[0] = Math.max(mat[0] , side);
  // return dp[i][j] = side;
  // }
}