class Solution {
  // Using the cycle detection algorithm, if we encounter a cycle that means it won't reach the terminal node. Coz terminal node doesnt have any outgoing edges.
    public List<Integer> eventualSafeNodes(int[][] graph) {
      
      int n = graph.length;
      boolean[] vis = new boolean[n];
      boolean[] path = new boolean[n];

      for(int i = 0 ; i < n; i++){
        if(!vis[i]){
          // Cycle check algorithm
          cycleCheck(i , vis , path , graph);
        }
      }

      // If path visited is false, that means we have traversed this and reached terminal state as in the dfs we mark the path as false once we traverse all the nodes
      List<Integer> res = new ArrayList<>();
      for(int i = 0 ; i < n ; i++){
        if(!path[i]){
          res.add(i);
        }
      }

      return res;
    }


    private boolean cycleCheck(int node , boolean[] vis , boolean[] path , int[][] graph){
      vis[node] = true;
      path[node] = true;

      for(int child : graph[node]){
        if(!vis[child]){
          if(cycleCheck(child , vis , path , graph)) return true;
        }

        if(path[child]){
          return true;
        }
      }

      path[node] = false;
      return false;
    }
}