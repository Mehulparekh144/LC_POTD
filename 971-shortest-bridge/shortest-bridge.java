class Solution {
    int m;
    int n;
    public int shortestBridge(int[][] grid) {
      m = grid.length;
      n = grid[0].length;
      int count = 0;

      boolean[][] vis = new boolean[m][n];

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(grid[i][j] == 1){
            dfs(i , j , grid , vis);
            return bfs(grid , vis);
          }
        }
      }

      return -1;
    }

    private void dfs(int i , int j , int[][] grid , boolean[][] vis){
      if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || grid[i][j] == 0){
        return;
      }

      vis[i][j] = true;
      dfs(i+1 , j , grid , vis);
      dfs(i-1 , j , grid , vis);
      dfs(i , j+1 , grid , vis);
      dfs(i , j-1 , grid , vis);
    }

    private int bfs(int[][] grid , boolean[][] vis){
      Queue<int[]> q = new LinkedList<>();

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(vis[i][j]) q.offer(new int[]{i , j});
        }
      }

      int[][] dirs = {
        {0,1} , {0,-1} , {1,0} , {-1,0}
      };

      int level = 0;

      while(!q.isEmpty()){
        int size = q.size();

        while(size != 0){
          int[] pair = q.poll();
          int i = pair[0] , j = pair[1];

          for(int[] d : dirs){
            int newi = i + d[0];
            int newj = j + d[1];

            if(newi < 0 || newj < 0 || newi >= m || newj >= n || vis[newi][newj] ) continue;

            if(grid[newi][newj] == 1) return level;
            vis[newi][newj] = true;
            q.offer(new int[]{newi , newj});
          }

          size--;
        }

        level++;
      }

      return level;


    }

}