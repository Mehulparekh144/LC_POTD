import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }

        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);

        long[] ways = new long[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        times[0] = 0;

        while (!pq.isEmpty()) {
            long[] pair = pq.poll();
            int node = (int) pair[0];
            long time = pair[1];

            if (time > times[node]) {
                continue;
            }

            for (long[] tpair : adj.get(node)) {
                int child = (int) tpair[0];
                long t = tpair[1];

                if (times[child] > t + time) {
                    times[child] = t + time;
                    ways[child] = ways[node];
                    pq.offer(new long[]{child, times[child]});
                } else if (times[child] == t + time) {
                    ways[child] = (ways[child] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1] % MOD;
    }
}
