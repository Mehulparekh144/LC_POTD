
class Solution {
  class Pair {
    String node;
    double val;

    public Pair(String node, double val) {
      this.node = node;
      this.val = val;
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Pair>> map = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      String from = equations.get(i).get(0);
      String to = equations.get(i).get(1);
      double val = values[i];

      map.computeIfAbsent(from, k -> new ArrayList<>()).add(new Pair(to, val));
      map.computeIfAbsent(to, k -> new ArrayList<>()).add(new Pair(from, 1.0 / val));
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String a = queries.get(i).get(0);
      String b = queries.get(i).get(1);

      if (!map.containsKey(a) || !map.containsKey(b)) {
        res[i] = -1.0;
      } else {
        res[i] = eval(a, b, map);
      }
    }

    return res;
  }

  private double eval(String a, String b, Map<String, List<Pair>> adj) {
    Queue<Pair> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    q.offer(new Pair(a, 1.0));
    visited.add(a);

    while (!q.isEmpty()) {
      Pair p = q.poll();
      String node = p.node;
      double val = p.val;

      if (node.equals(b)) {
        return val;
      }

      for (Pair neighbor : adj.get(node)) {
        if (!visited.contains(neighbor.node)) {
          visited.add(neighbor.node);
          q.offer(new Pair(neighbor.node, val * neighbor.val));
        }
      }
    }

    return -1.0;
  }
}
