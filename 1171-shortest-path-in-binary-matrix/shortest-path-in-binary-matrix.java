class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1)
      return -1;
    int m = grid.length;
    int n = grid[0].length;
    int[][] dis = new int[m][n];
    for (int[] d : dis) {
      Arrays.fill(d, (int) 1e9);
    }

    Queue<int[]> q = new LinkedList<>();
    dis[0][0] = 1;
    q.offer(new int[] { 0, 0 });

    while (!q.isEmpty()) {
      int[] pair = q.poll();
      int r = pair[0];
      int c = pair[1];

      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i != 0 || j != 0) {
            int nr = r + i;
            int nc = c + j;

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 1) {
              continue;
            }

              if (dis[nr][nc] > 1 + dis[r][c]) {
                dis[nr][nc] = 1 + dis[r][c];
                q.offer(new int[] { nr, nc });
              }
          }
        }
      }
    }

    return dis[m - 1][n - 1] == 1e9 ? -1 : dis[m - 1][n - 1];
  }
}