class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= isConnected.length ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1 ; i <= isConnected.length ; i++){
            for(int j = 1 ; j <= isConnected.length ; j++){
                if(isConnected[i-1][j-1] == 1 && i != j){
                adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length + 1];

        int res = 0;
        for(int i = 1 ; i <= isConnected.length ; i++){
            if(!visited[i]){
                res++;
                dfs(i , visited, adj);
            }
        }

        return res;

    }

  private void dfs(int start , boolean[] visited , List<List<Integer>> adj){
    visited[start] = true;
    for(int child : adj.get(start)){
      if(!visited[child]){
        dfs(child , visited , adj);
      }
    }
  }
}