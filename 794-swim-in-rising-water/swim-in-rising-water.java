class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0 , 0 , grid[0][0]});
        vis[0][0] = true;

        int[][] dirs = new int[][]{
          {0,1} , {0,-1} , {1,0} , {-1,0}
        };

        while(!pq.isEmpty()){
          int[] pair = pq.poll();
          int i = pair[0];
          int j = pair[1];
          int ht = pair[2];

          if(i == n-1 && j == n-1){
            return ht;
          }

          for(int[] dir : dirs){
            int newi = i + dir[0];
            int newj = j + dir[1];

            if(newi < 0 || newj < 0 || newi >= n || newj >= n || vis[newi][newj]){
              continue;
            }

              vis[newi][newj] = true;
              pq.offer(new int[]{newi , newj , Math.max(ht , grid[newi][newj])});

          }

        }

        return -1;
    }
}