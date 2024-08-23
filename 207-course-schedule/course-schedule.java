class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      boolean[] vis = new boolean[numCourses];
      boolean[] path = new boolean[numCourses];

      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0 ; i < numCourses ; i++){
        adj.add(new ArrayList<>());
      }

      for(int[] edge : prerequisites){
        adj.get(edge[1]).add(edge[0]);
      }

      for(int i = 0 ; i < numCourses ; i++){
        if(dfs(i , vis , path , adj)){
          return false;
        }
      }

      return true;
    }

    // Checks cycle
    private boolean dfs(int i , boolean[] vis , boolean[] path , List<List<Integer>> adj){
      vis[i] = true;
      path[i] = true;

      for(int child : adj.get(i)){
        if(!vis[child]){
          if(dfs(child , vis , path , adj)){
            return true;
          }
        }

        if(path[child]){
          return true;
        }
      }

      path[i] = false;
      return false;
    }
}