class Solution {
  class Pair {
    char ch;
    long cost;

    public Pair(char ch, long cost) {
      this.ch = ch;
      this.cost = cost;
    }
  }

  private Map<String, Long> memo;

  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    long counts = 0;
    memo = new HashMap<>();
    Map<Character, List<Pair>> adj = new HashMap<>();

    for (int i = 0; i < cost.length; i++) {
      char ch = original[i];
      adj.put(ch, new ArrayList<>());
    }

    for (int i = 0; i < cost.length; i++) {
      char ch = original[i];
      char to = changed[i];
      int c = cost[i];

      adj.get(ch).add(new Pair(to, c));
    }

    for (int i = 0; i < source.length(); i++) {
      if (source.charAt(i) != target.charAt(i)) {
        long cost_ = getCost(source.charAt(i), target.charAt(i), adj);
        if (cost_ == -1) {
          return -1;
        }

        counts += cost_;
      }
    }

    return counts;
  }

  private long getCost(char start, char end, Map<Character, List<Pair>> adj) {

    String key = start + "-" + end;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    long[] costs = new long[26];
    Arrays.fill(costs, Long.MAX_VALUE);
    costs[start - 'a'] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

    pq.offer(new Pair(start, 0));

    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      char ch = p.ch;
      long cost = p.cost;

      if (ch == end) {
        memo.put(key, cost);
        return cost;
      }

      if (adj.get(ch) == null)
        continue;

      for (Pair childP : adj.get(ch)) {
        char child = childP.ch;
        long childCost = childP.cost;

        if (childCost + cost < costs[child - 'a']) {
          costs[child - 'a'] = childCost + cost;
          pq.offer(new Pair(child, costs[child - 'a']));
        }
      }
    }
    memo.put(key, -1L);
    return -1;

  }
}