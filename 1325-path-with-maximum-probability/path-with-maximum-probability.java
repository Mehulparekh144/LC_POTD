class Solution {
  class Pair {
    int node;
    double prob;

    public Pair(int node, double prob) {
      this.node = node;
      this.prob = prob;
    }
  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    List<List<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      double prob = succProb[i];
      int u = edge[0], v = edge[1];

      adj.get(u).add(new Pair(v, prob));
      adj.get(v).add(new Pair(u, prob));
    }

    double[] probability = new double[n];
    Arrays.fill(probability, 0);

    probability[start] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Double.compare(b.prob , a.prob));
    q.offer(new Pair(start, 1));

    while (!q.isEmpty()) {
      Pair p = q.poll();
      int node = p.node;
      double prob = p.prob;

      if (node == end)
        return prob;

      for (Pair p1 : adj.get(node)) {
        int child = p1.node;
        double childProb = p1.prob;

        if (probability[child] < childProb * prob) {
          probability[child] = childProb * prob;
          q.offer(new Pair(child, probability[child]));
        }
      }
    }

    return probability[end];

  }
}