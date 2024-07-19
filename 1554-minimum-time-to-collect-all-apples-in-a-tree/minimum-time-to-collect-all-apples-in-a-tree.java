class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
          adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
        }

        return dfs(0 , -1 , adj , hasApple);
    }

    private int dfs(int start , int parent , List<List<Integer>> adj , List<Boolean> hasApple){
      int time = 0;

      for(int child : adj.get(start)){
        if(child == parent) continue;

        int timeFromChild = dfs(child , start , adj , hasApple);

        if(timeFromChild > 0 || hasApple.get(child) == true){
          time += timeFromChild + 2;
        }
      }

      return time;
    }
}