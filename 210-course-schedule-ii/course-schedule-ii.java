class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] res = new int[n];
        int[] indegree = new int[n];

        for(int i = 0 ; i < n ; i++){
          adj.add(new ArrayList<>());
        }

        for(int[] e : prerequisites){
          adj.get(e[1]).add(e[0]);
          indegree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
          if(indegree[i] == 0) q.offer(i);
        }


        int i = 0;
        while(!q.isEmpty()){
          int node = q.poll();
          res[i++] = node;

          for(int child : adj.get(node)){
            indegree[child]--;
            if(indegree[child] == 0){
              q.offer(child);
            }
          }
        }

        if(i != n){
          return new int[]{};
        }

        return res;
    }
}