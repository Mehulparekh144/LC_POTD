class Solution {
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;

        for(int i = 0 ; i < m ; i++){
          for(int j = 0 ; j < n ; j++){
            if(grid[i][j] == 1){
              res = Math.max(res , dfs(i , j , grid));
            }
          }
        }

        return res;
    }

    private int dfs(int i , int j , int[][] grid){
      if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1){
        return 0;
      }

      int res = 1;
      grid[i][j] = 0;

      int[][] dir = {
        {0,1} , {0,-1} , {1,0} , {-1,0}
      };

      for(int[] d : dir){
        res += dfs(i + d[0] , j + d[1] , grid);
      }

      return res;
    }
}