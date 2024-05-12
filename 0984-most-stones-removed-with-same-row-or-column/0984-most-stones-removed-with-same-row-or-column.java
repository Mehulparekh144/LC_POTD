class DisjointSet{
    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n){
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int find(int node){
        if(parent.get(node) == node) return node;
        parent.set(node , find(parent.get(node)));
        return parent.get(node);
    }

    public void union(int u , int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;

        int sizeU = size.get(u);
        int sizeV = size.get(v);

        if(sizeU > sizeV){
            parent.set(pv , pu);
            size.set(pu , sizeU + sizeV);
        } else{
            parent.set(pu , pv);
            size.set(pv , sizeU + sizeV);
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(stone[0] , maxRow);
            maxCol = Math.max(stone[1] , maxCol);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Set<Integer> set = new HashSet<>();
        for(int[] stone : stones){
            ds.union(stone[0] , stone[1] + maxRow + 1);
            set.add(stone[0]);
            set.add(stone[1] + maxRow + 1);
        }

        int cnt = 0;
        for(int stone : set){
            if(ds.find(stone) == stone){
                cnt++;
            }
        }

        return stones.length - cnt;

    }
}