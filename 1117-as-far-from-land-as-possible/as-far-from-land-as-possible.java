class Solution {
  public int maxDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          q.offer(new int[] { i, j});
        }
      }
    }

    int res = -1;
    int[][] dirs = {
        { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
    };

    while (!q.isEmpty()) {
      int[] p = q.poll();
      int i = p[0];
      int j = p[1];

      res = grid[i][j];

      for (int[] d : dirs) {
        int newi = i + d[0];
        int newj = j + d[1];

        if (newi < 0 || newj < 0 || newi >= m || newj >= n || grid[newi][newj] != 0)
          continue;

        q.offer(new int[] { newi, newj });
        grid[newi][newj] = grid[i][j] + 1;
      }

    }


    if (res <= 1)
      return -1;
    return res - 1;
  }
}