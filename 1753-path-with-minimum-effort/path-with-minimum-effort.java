class Solution {
    public int minimumEffortPath(int[][] heights) {
      int m = heights.length;
      int n = heights[0].length;

      int[][] dis = new int[m][n];
      for(int[] row : dis) Arrays.fill(row , (int) 1e9);

      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
      pq.offer(new int[]{0 , 0 , 0});
      dis[0][0] = 0;

      int[][] dirs = new int[][]{
        {0,1} , {1,0} , {0,-1} , {-1,0}
      };

      while(!pq.isEmpty()){
        int[] pair = pq.poll();
        int effort = pair[0];
        int r = pair[1];
        int c = pair[2];

        if(r == m-1 && c == n-1){
          return effort;
        }

        for(int[] dir : dirs){
          int nr = dir[0] + r;
          int nc = dir[1] + c;

          if(nr < 0 || nc < 0 || nr >= m || nc >= n){
            continue;
          }

          int newEffort = Math.max(effort , Math.abs(heights[nr][nc] - heights[r][c]));

          if(newEffort < dis[nr][nc]){
            dis[nr][nc] = newEffort;
            pq.offer(new int[]{newEffort , nr , nc});
          }
          
        }
      }  

      return -1;
    }
}