class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        long[] importance = new long[n];

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }


        Integer[] nodes = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            nodes[i] = i;
        }

        Arrays.sort(nodes , (a,b) -> degree[b] - degree[a]);
        for (int i = 0; i < n; i++) {
            importance[nodes[i]] = n-i;
        }

        long sum = 0;
        for(int[] edge : roads){
            sum += importance[edge[0]] + importance[edge[1]];
        };

        return sum;



    }
}