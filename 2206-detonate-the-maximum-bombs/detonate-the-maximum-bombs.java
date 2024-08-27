class Solution {
  public int maximumDetonation(int[][] bombs) {
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < bombs.length; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < bombs.length; i++) {
      for (int j = 0; j < bombs.length; j++) {
        if (i != j) {
          long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
          long x2 = bombs[j][0], y2 = bombs[j][1];

          long distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
          
          if (distanceSquared <= r1 * r1) {
            adj.get(i).add(j);
          }
        }
      }
    }

    int res = 0;
    for (int i = 0; i < bombs.length; i++) {
      res = Math.max(res, dfs(i, new HashSet<>(), adj));
    }

    return res;
  }

  private int dfs(int i, Set<Integer> vis, List<List<Integer>> adj) {
    if (vis.contains(i))
      return 0;

    vis.add(i);

    for (int child : adj.get(i)) {
      dfs(child, vis, adj);
    }

    return vis.size();
  }
}
