import java.util.*;

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        // Step 1 : Check for shortest path without considering -1 edges 
        // 1. if that's less than target return {} 
        // 2. if it's equal to target return edges
        // 3. if it's greater than target . Try -1 edges one by one and keep checking Shortest Path 
        //    as soon as it goes <= target modify the edge to add target - sp.

        long shortestPath = dijkstra(edges, source, destination, n); // Excluding -1

        if (shortestPath < target) {
            return new int[][]{};
        }

        boolean match = shortestPath == target;

        for (int[] edge : edges) {
            if (edge[2] == -1) {
                // Set large value for -1 edges if match
                edge[2] = match ? (int) 2e9 : 1;

                if (!match) {
                    long newShortestPath = dijkstra(edges, source, destination, n);

                    if (newShortestPath <= target) {
                        match = true;
                        // Modify the edge weight accordingly to achieve target
                        edge[2] += (int) (target - newShortestPath);
                    }
                }
            }
        }

        if (!match) return new int[][]{};

        // Ensure final path equals target after modifications
        if (dijkstra(edges, source, destination, n) != target) {
            return new int[][]{};
        }

        return edges;
    }

    private long dijkstra(int[][] edges, int source, int destination, int n) {
        List<List<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], dist = edge[2];
            if (dist == -1) continue; // Ignore -1 edges in initial Dijkstra call

            adj.get(u).add(new long[]{v, dist});
            adj.get(v).add(new long[]{u, dist});
        }

        boolean[] vis = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{source, 0});
        dist[source] = 0;

        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            int node = (int) p[0];
            long dis = p[1];

            if (vis[node]) continue;

            vis[node] = true;

            for (long[] pair : adj.get(node)) {
                int child = (int) pair[0];
                long childDist = pair[1];

                if (dist[child] > childDist + dis) {
                    dist[child] = childDist + dis;
                    pq.offer(new long[]{child, dist[child]});
                }
            }
        }

        // If destination is unreachable, return Long.MAX_VALUE to signal no valid path.
        return dist[destination] == Long.MAX_VALUE ? Long.MAX_VALUE : dist[destination];
    }
}
