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
            bfs(i , j , grid);
            count++;
          }
        }
      }

      return count;
    }

    private void bfs(int i , int j , char[][] grid){
      int[][] dirs = { 
        {0,1} , {0,-1} , {1,0} , {-1 , 0}
       };

       Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{i , j});

       while(!q.isEmpty()){
        int[] p = q.poll();
        int r = p[0] , c = p[1];

        for(int[] dir : dirs){
          int newr = r + dir[0];
          int newc = c + dir[1];

          if(newr < 0 || newc < 0 || newr >= m || newc >= n || grid[newr][newc] != '1') continue;

          grid[newr][newc] = '0';
          q.offer(new int[]{newr , newc});
        }
       }
    }


}