class Solution {
  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    Map<Integer, List<int[]>> map = new HashMap<>();


    for (int[] m : meetings) {
      int u = m[0];
      int v = m[1];
      int t = m[2];

      map.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { v, t });
      map.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { u, t });
    }

    Queue<int[]> q = new LinkedList<>();
    int[] vis = new int[n];
    Arrays.fill(vis, Integer.MAX_VALUE);

    vis[0] = 0;
    vis[firstPerson] = 0;

    q.offer(new int[] { 0, 0 });
    q.offer(new int[] { firstPerson, 0 });

    while (!q.isEmpty()) {
      int[] p = q.poll();
      int node = p[0], time = p[1];

      if(!map.containsKey(node)) continue;

      for (int[] p1 : map.get(node)) {
        int child = p1[0];
        int t = p1[1];

        if (t >= time && vis[child] > t) {
          vis[child] = t;
          q.offer(new int[] { child, t });
        }
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (vis[i] != Integer.MAX_VALUE) {
        res.add(i);
      }
    }

    return res;
  }
}