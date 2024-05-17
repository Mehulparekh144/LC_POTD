class DisjointSet{
  List<Integer> parent;
  List<Integer> size;

  public DisjointSet(int n ){
    parent = new ArrayList<>();
    size = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      parent.add(i);
      size.add(1);
    }
  }

    public int findUPar(int node){
      if(node == parent.get(node)) return node;
      parent.set(node , findUPar(parent.get(node)));
      return parent.get(node);
    }

    public void unionBySize(int u , int v){
      int pu = findUPar(u);
      int pv = findUPar(v);
      if(pu == pv) return;
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
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      DisjointSet d = new DisjointSet(edges.length + 1);
      for(int[] edge : edges){
        if(d.findUPar(edge[0]) == d.findUPar(edge[1])){
          return edge;
        } else{
          d.unionBySize(edge[0] , edge[1]);
        }
      }

      return new int[]{0};
    }
}