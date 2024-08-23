class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

      // Reverse the edges
      List<List<Integer>> adj = new ArrayList<>();
      int[] indegree = new int[graph.length];

      for(int i = 0 ; i < graph.length ; i++){
        adj.add(new ArrayList<>());
      }

      for(int i = 0 ; i < graph.length ; i++){
        for(int e : graph[i]){
          adj.get(e).add(i);
          indegree[i]++;
        }
      }

      // Perform TOPO
      List<Integer> res = new ArrayList<>();
      topo(adj , indegree , res);
      Collections.sort(res);

      return res;
    }

    private void topo(List<List<Integer>> adj , int[] indegree  , List<Integer> res){
      int n = adj.size();
      Queue<Integer> q = new LinkedList<>();

      for(int i = 0 ; i < n ; i++){
        if(indegree[i] == 0){
          q.offer(i);
        }
      }

      while(!q.isEmpty()){
        int node = q.poll();
        res.addLast(node);

        for(int child : adj.get(node)){
          indegree[child]--;
          if(indegree[child] == 0) q.offer(child);
        }
      }
    }
}