class Solution {
  public int secondMinimum(int n, int[][] edges, int time, int change) {
    List<List<Integer>> adj = new ArrayList<>();

    List<List<Integer>> visitedTimes = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
      visitedTimes.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    Queue<Integer> q = new LinkedList<>();
    q.offer(1);

    int currTime = 0;
    int res = -1;

    while (!q.isEmpty()) {
      int len = q.size();

      for (int i = 0; i < len; i++) {
        int node = q.poll();

        if (node == n) {
          if (res != -1) {
            return currTime;
          }

          res = currTime;
        }

        for (int child : adj.get(node)) {
          List<Integer> v = visitedTimes.get(child);
          if ((v.isEmpty()) || (v.size() == 1 && v.get(0) != currTime)) {
            q.offer(child);
            v.add(currTime);
          }
        }
      }

      if ((currTime / change) % 2 == 1) {
        currTime += change - (currTime % change);
      }

      currTime += time;
    }

    return res;
  }
}
