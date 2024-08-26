class Solution {
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int[] r : redEdges){
          adj.get(r[0]).add(new int[]{r[1] , 1});
        }

        for(int[] b : blueEdges){
          adj.get(b[0]).add(new int[]{b[1] , 0});
        }

        int[][] dis = new int[n][2];

        for(int i = 0 ; i < n ; i++){
          dis[i][0] = -1;
          dis[i][1] = -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , 1});
        q.offer(new int[]{0 , 0});

        dis[0][0] = dis[0][1] = 0;
      

        while(!q.isEmpty()){
          int[] p = q.poll();
          int node = p[0];
          int color = p[1];

          for(int[] c : adj.get(node)){
            int child = c[0];
            int childColor = c[1];

            if(childColor != color && dis[child][childColor] == -1){
              dis[child][childColor] = 1 + dis[node][color];
              q.offer(new int[]{child , childColor});
            }
          }
        }

        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
          if(dis[i][0] == -1 && dis[i][1] == -1){
            res[i] = -1;
          } else if(dis[i][1] == -1){
            res[i] = dis[i][0];
          } else if(dis[i][0] == -1){
            res[i] = dis[i][1];
          } else{
            res[i] = Math.min(dis[i][1] , dis[i][0]);
          }
        }

        return res;
    }
}