class Solution {
    class Pair {
        int price;
        int node;
        int stops;

        public Pair(int price, int node, int stops) {
            this.price = price;
            this.node = node;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src, 0));

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int price = q.peek().price;
            int stops = q.peek().stops;
            q.poll();

            if (stops > k) {
                continue;
            }

            for (int[] child : adj.get(node)) {
                if ((cost[child[0]] > price + child[1]) && (stops <= k)) {
                    cost[child[0]] = price + child[1];
                    q.offer(new Pair(cost[child[0]], child[0], stops + 1));
                }
            }
        }
        if(cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}