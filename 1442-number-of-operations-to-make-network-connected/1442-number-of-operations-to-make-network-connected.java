class DisjointSet {
    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n) {
        size = new ArrayList<>();
        parent = new ArrayList<>();
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

        int sizeU = size.get(pu);
        int sizeV = size.get(pv);

        if (sizeU > sizeV) {
            parent.set(pv, pu);
            size.set(pu, sizeU + sizeV);
        } else {
            parent.set(pu, pv);
            size.set(pv, sizeU + sizeV);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet d = new DisjointSet(n);
        int extraCables = 0;
        for(int[] connection : connections){
            if(d.find(connection[0]) == d.find(connection[1])){
                extraCables++;
            } else{
                d.union(connection[0] , connection[1]);
            }
        }

        int notConnected = 0;
        for(int i = 0 ; i < n ; i++){
            if(d.parent.get(i) == i) notConnected++;
        }

        int answer = notConnected - 1;
        if(extraCables >= answer) return answer ;
        return -1;
        

    }
}