class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
      int count = 0;
      m = grid.length;
      n = grid[0].length;

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(grid[i][j] == '1'){
            dfs(i , j , grid);
            count++;
          }
        }
      }

      return count;
    }

    private void dfs(int i , int j , char[][] grid){
      if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' ) return;

      grid[i][j] = '0';

      dfs(i+1 , j , grid);
      dfs(i-1 , j , grid);
      dfs(i , j+1 , grid);
      dfs(i , j-1 , grid);

    }
}