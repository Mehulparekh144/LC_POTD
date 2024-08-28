class Solution {
    int m;
    int n;
    public int getMaximumGold(int[][] grid) {
      m = grid.length;
      n = grid[0].length;

      int max = 0;

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(grid[i][j] != 0){
            max = Math.max(
              max,
              dfs(i , j , grid)
            );
          }
        }
      }

      return max;
    }

    private int dfs(int i , int j , int[][] grid){
      if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

      int curr = grid[i][j];
      grid[i][j] = 0;

      int res = 0;
      int up = curr + dfs(i-1 , j , grid);
      int down = curr + dfs(i+1 , j , grid);
      int left = curr + dfs(i , j-1 , grid);
      int right = curr + dfs(i , j+1 , grid);

      res=  Math.max(Math.max(up , down) , Math.max(left , right));
      grid[i][j] = curr;

      return res;
    }
}