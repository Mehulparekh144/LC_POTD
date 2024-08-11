class Solution {
    int goodNodes = 0;
    public int countGoodNodes(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i <= edges.length ; i++){
          adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
        }

        dfs(0 , -1 , adj);
        return goodNodes;
    }

    private int dfs(int node , int parent , List<List<Integer>> adj){
      int size = 1;
      Set<Integer> set = new HashSet<>();

      for(int child : adj.get(node)){
        if(child == parent) continue;

        int subtreeSize = dfs(child , node , adj);
        size += subtreeSize;
        set.add(subtreeSize);
      }

      if(set.size() <= 1) goodNodes++;
      return size;
    }
}