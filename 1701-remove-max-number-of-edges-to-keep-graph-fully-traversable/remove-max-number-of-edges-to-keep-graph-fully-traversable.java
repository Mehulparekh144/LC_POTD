class DisjointSet {
    List<Integer> parent;
    List<Integer> size;
    int components;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        components = n;

        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }

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

        components--;
    }

}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet ds1 = new DisjointSet(n);
        DisjointSet ds2 = new DisjointSet(n);
        int e = 0;

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {
                boolean flag = false;
                if (ds1.findUPar(u) != ds1.findUPar(v)) {
                    ds1.union(u, v);
                    flag = true;
                }

                if (ds2.findUPar(u) != ds2.findUPar(v)) {
                    ds2.union(u, v);
                    flag = true;
                }

                if(flag){
                    e++;
                }

            } else if (type == 2) {

                if (ds2.findUPar(u) != ds2.findUPar(v)) {
                    ds2.union(u, v);
                    e++;
                }

            } else {
                if (ds1.findUPar(u) != ds1.findUPar(v)) {
                    ds1.union(u, v);
                    e++;
                }
            }

        }

        if(ds1.components == 1 && ds2.components == 1){
        return edges.length - e;
        }

        return -1;

    }
}