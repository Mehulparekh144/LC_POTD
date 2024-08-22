class Solution {
  int count;

  public int minReorder(int n, int[][] connections) {
    List<List<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : connections) {
      adj.get(edge[0]).add(new int[] { edge[1], 1 }); // Original Edge
      adj.get(edge[1]).add(new int[] { edge[0], 0 }); // Fake edge
    }

    count = 0;
    dfs(-1, 0, adj);
    return count;

  }

  private void dfs(int par, int node, List<List<int[]>> adj) {

    for (int[] p : adj.get(node)) {
      int child = p[0], type = p[1];

      if (child != par) {
        if (type == 1) {
          count++;
        }

        dfs(node, child , adj);
      }

    }
  }
}