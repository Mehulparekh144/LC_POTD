class Solution {
  class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n) {
      parent = new ArrayList<>();
      size = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        parent.add(i);
        size.add(1);
      }
    }

    public int find(int node) {
      if (node == parent.get(node))
        return node;
      parent.set(node, find(parent.get(node)));
      return parent.get(node);
    }

    public void union(int u, int v) {
      int pu = find(u);
      int pv = find(v);

      if (pu == pv)
        return;
      int sizeu = size.get(pu);
      int sizev = size.get(pv);

      if (sizeu > sizev) {
        parent.set(pv, pu);
        size.set(pu, sizeu + sizev);
      } else {
        parent.set(pu, pv);
        size.set(pv, sizeu + sizev);
      }
    }
  }

  public int minCostConnectPoints(int[][] points) {
    List<int[]> edges = new ArrayList<>();

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];

        int x2 = points[j][0];
        int y2 = points[j][1];

        int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        edges.add(new int[] { i, j, d });

      }
    }

    return kruskal(edges , points.length);
  }

  private int kruskal(List<int[]> edges , int n) {
    int sum = 0;
    DisjointSet ds = new DisjointSet(n);

    Collections.sort(edges, (a, b) -> a[2] - b[2]);

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int d = edge[2];

      if (ds.find(u) != ds.find(v)) {
        sum += d;
        ds.union(u, v);
      }
    }

    return sum;
  }

}