class Solution {
    class DisjointSet{
      int[] parent;
      int[] size;

      public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0 ; i < n ; i++){
          parent[i] = i;
          size[i] = 1;
        }
      }

      public int find(int node){
        if(node == parent[node]) return node;
        parent[node] = find(parent[node]);
        return parent[node];
      }

      public void union(int u , int v){
        int pu = find(u) , pv = find(v);
        if(pu == pv) return;

        int sizeu = size[pu] , sizev = size[pv];

        if(sizeu > sizev){
          parent[pv] = pu;
          size[pu] = sizeu + sizev;
        } else{
          parent[pu] = pv;
          size[pv] = sizeu + sizev;
        }
      }
    }
    public int removeStones(int[][] stones) {
        int r = 0;
        int c = 0;

        for(int[] stone : stones){
          r = Math.max(r , stone[0]);
          c = Math.max(c , stone[1]);
        }

        DisjointSet ds = new DisjointSet(r + c + 2);
        Set<Integer> s = new HashSet<>();
        for(int[] stone : stones){
          int i = stone[0];
          int j = stone[1] + r + 1;

            ds.union(i , j);


          s.add(i);
          s.add(j);
        }

        int left = 0;
        for(int stone : s){
          if(ds.find(stone) == stone){
            left++;
          }
        }

        return stones.length - left;


    }
}