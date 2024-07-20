class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
          adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
          if(manager[i] == -1) continue;
          adj.get(manager[i]).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID , informTime[headID]});

        int res = 0;

        while(!q.isEmpty()){
          int[] p = q.poll();
          int node = p[0];
          int time = p[1];

          res = Math.max(res , time);

          for(int child : adj.get(node)){
            q.offer(new int[]{child , time + informTime[child]});
          }
        }

        return res;


    }
}