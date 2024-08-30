class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> adj = new HashMap<>();

    for (int[] e : flights) {
      int from = e[0], to = e[1], price = e[2];

      adj.computeIfAbsent(from, m -> new ArrayList<>()).add(new int[] { to, price });
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[] { src, 0, 0 });

    int[] prices = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);
    prices[src] = 0;

    int[] minStops = new int[n];
    Arrays.fill(minStops, Integer.MAX_VALUE);
    minStops[src] = 0;

    while (!pq.isEmpty()) {
      int[] pair = pq.poll();
      int node = pair[0], currPrice = pair[1], currK = pair[2];

      if(node == dst) return currPrice;

      if (currK > k)
        continue;
      
      if(!adj.containsKey(node)) continue;

      for (int[] childPair : adj.get(node)) {
        int child = childPair[0];
        int ticket = childPair[1];

        if (prices[child] > ticket + currPrice || minStops[child] > currK + 1) {
          prices[child] = ticket + currPrice;
          minStops[child] = currK + 1;
          pq.offer(new int[] { child, prices[child], currK + 1 });
        }
      }
    }

    return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

  }
}