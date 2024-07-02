class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < graph.length ; i++){
          adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < graph.length ; i++){
          for(int child : graph[i]){
            adj.get(child).add(i);
          }
        }

        List<Integer> res = new ArrayList<>();
        topo(adj , res , graph.length);
        Collections.sort(res);
        return res;
    }

    private void topo(List<List<Integer>> adj , List<Integer> res , int n){
      int[] indegree = new int[n];
      for(int i = 0 ; i < n ; i++){
        for(int child : adj.get(i)){
          indegree[child]++;
        } 
      }

      Queue<Integer> q = new LinkedList<>();

      for(int i = 0 ; i < n ; i++){
        if(indegree[i] == 0) q.offer(i);
      }

      while(!q.isEmpty()){
        int node = q.poll();
        res.add(node);

        for(int child : adj.get(node)){
          indegree[child]--;
          if(indegree[child] == 0){
            q.offer(child);
          }
        }
      }
    }
}