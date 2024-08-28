class Solution {
  public int minimumTime(int n, int[][] relations, int[] time) {
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegree = new int[n + 1];
    int[] minTime = new int[n + 1];
    for (int[] e : relations) {
      int from = e[0], to = e[1];
      adj.get(from).add(to);
      indegree[to]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
        minTime[i] = time[i - 1];
      }
    }

    while (!q.isEmpty()) {

      int node = q.poll();
      
      for (int child : adj.get(node)) {
        minTime[child] = Math.max(minTime[child] , minTime[node] + time[child - 1]);
        indegree[child]--;
        if (indegree[child] == 0)
          q.offer(child);
      }

    }

    int ans = 0;
    for(int child : minTime){
      ans = Math.max(ans , child);
    }

    return ans;

  }
}