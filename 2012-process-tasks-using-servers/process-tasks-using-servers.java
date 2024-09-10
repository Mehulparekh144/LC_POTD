class Solution {
  public int[] assignTasks(int[] servers, int[] tasks) {
    // Wt , index
    PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int i = 0; i < servers.length; i++) {
      available.offer(new int[] { servers[i], i });
    }

    // Timefree , weight , index
    PriorityQueue<int[]> unavailable = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    int[] res = new int[tasks.length];
    int t = 0;

    for (int i = 0; i < tasks.length; i++) {
      t = Math.max(t, i);

      if (available.isEmpty()) {
        t = unavailable.peek()[0];
      }

      while (!unavailable.isEmpty() && t >= unavailable.peek()[0]) {
        int[] server = unavailable.poll();
        available.offer(new int[] { server[1], server[2] });
      }

      int[] p = available.poll();
      int wt = p[0];
      int idx = p[1];
    

      res[i] = idx;
      unavailable.offer(new int[] {
          t + tasks[i], wt, idx
      });
    }

    return res;
  }
}