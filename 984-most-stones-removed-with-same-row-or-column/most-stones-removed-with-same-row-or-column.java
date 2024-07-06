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

  public int removeStones(int[][] stones) {
    int maxRow = 0;
    int maxCol = 0;
    for (int[] stone : stones) {
      maxCol = Math.max(maxCol, stone[1]);
      maxRow = Math.max(maxRow, stone[0]);
    }

    DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
    Set<Integer> s = new HashSet<>();

    for (int[] stone : stones) {
      ds.union(stone[0], stone[1] + maxRow + 1);
      s.add(stone[0]);
      s.add(stone[1] + maxRow + 1);
    }

    int left = 0;
    for (int stone : s) {
      if (stone == ds.find(stone))
        left++;
    }

    return stones.length - left;
  }
}