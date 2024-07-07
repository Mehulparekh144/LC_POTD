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

    public int find(int node){
      if(node == parent.get(node)){
        return node;
      }

      parent.set(node , find(parent.get(node)));
      return parent.get(node);
    }

    public void union(int u , int v){
      int pu = find(u);
      int pv = find(v);

      if(pu == pv) {
        return;
      }

      int sizeu = size.get(pu);
      int sizev = size.get(pv);

      if(sizeu > sizev){
        parent.set(pv , pu);
        size.set(pu , sizeu + sizev);
      } else{
        parent.set(pu , pv);
        size.set(pv , sizeu + sizev);
      }
    }

  }

  public int[] findRedundantConnection(int[][] edges) {
    DisjointSet ds = new DisjointSet(edges.length + 1);
    int[] pair = new int[]{};
    for(int[] edge : edges){
      int u = edge[0];
      int v = edge[1];

      if(ds.find(u) == ds.find(v)){
        pair = edge;
      } else{
        ds.union(u , v);
      }
    }

    return pair;

    
  }
}