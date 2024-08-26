class Solution {
  private long res;

  public long minimumFuelCost(int[][] roads, int seats) {
    res = 0;
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i <= roads.length; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : roads) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }

    dfs(0, -1, adj, seats);
    return res;
  }

  private long dfs(int node, int parent, List<List<Integer>> adj, int seats) {
    long pass = 0;

    for (int child : adj.get(node)) {
      if (child != parent) {
        long p = dfs(child, node, adj, seats);
        pass += p;
        res += (long) Math.ceil((double) p / seats);
      }
    }

    // Pass means passengers from all children
    // +1 denoting itself
    return pass + 1;
  }
}