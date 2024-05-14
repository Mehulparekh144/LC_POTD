class DisjointSet {
  List<Integer> size;
  List<Integer> parent;

  public DisjointSet(int n) {
    size = new ArrayList<>();
    parent = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      size.add(1);
      parent.add(i);
    }
  }

  public int findUPar(int node) {
    if (node == parent.get(node))
      return node;
    parent.set(node, findUPar(parent.get(node)));
    return parent.get(node);
  }

  public void union(int u, int v) {
    int pu = findUPar(u);
    int pv = findUPar(v);
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

class Solution {
  public int largestIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    DisjointSet ds = new DisjointSet(m * n);
    int[] dirX = new int[] { -1, 0, 1, 0 };
    int[] dirY = new int[] { 0, -1, 0, 1 };

    for(int i = 0 ; i < m ; i++){
      for(int j = 0; j < n ; j++){
        if(grid[i][j] == 0) continue;

        for(int k = 0 ; k < 4 ; k++){
          int newi = i + dirX[k];
          int newj = j + dirY[k];

          if(newi >= 0 && newj >= 0 && newi < m && newj < n && grid[newi][newj] == 1){
            int u = newi*n + newj;
            int v = i*n + j;
            ds.union(u , v);
          }
        }
      }
    }

    int maxi = 0;
    for(int i = 0 ; i < m ; i++){
      for(int j = 0 ; j < n ; j++){
        if(grid[i][j] == 1) continue;
        Set<Integer> components = new HashSet<>();
        for(int k = 0 ; k < 4 ; k++){
          int newi = i + dirX[k];
          int newj = j + dirY[k];

          if(newi >= 0 && newj >= 0 && newi < m && newj < n){
            if(grid[newi][newj] == 1){
              int node = newi*n + newj;
              components.add(ds.findUPar(node));
            }
          }
        }
        int totalSize = 1;
        for(int component : components){
          totalSize += ds.size.get(component);
        }

        maxi = Math.max(maxi , totalSize);
      }
    }

    for(int i = 0 ; i < m*n; i++){
      maxi = Math.max(maxi , ds.size.get(ds.findUPar(i)));
    }

    return maxi;

  }
}