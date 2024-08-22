class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    boolean[][] pac = new boolean[m][n];
    boolean[][] atl = new boolean[m][n];

    Queue<int[]> pq = new LinkedList<>();
    Queue<int[]> aq = new LinkedList<>();

    for (int j = 0; j < n; j++) {
      pac[0][j] = true;
      atl[m - 1][j] = true;

      pq.offer(new int[] { 0, j });
      aq.offer(new int[] { m - 1, j });
    }

    for (int i = 0; i < m; i++) {
      pac[i][0] = true;
      atl[i][n-1] = true;

      pq.offer(new int[] { i, 0 });
      aq.offer(new int[] { i , n-1 });
    }

    bfs(pq, pac, heights);
    bfs(aq, atl, heights);

    List<List<Integer>> arr = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pac[i][j] && atl[i][j]) {
          arr.add(new ArrayList<>(List.of(i, j)));
        }
      }
    }

    return arr;
  }

  private void bfs(Queue<int[]> q, boolean[][] vis, int[][] heights) {
    int m = heights.length, n = heights[0].length;
    int[][] dir = {
        { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    while (!q.isEmpty()) {
      int[] p = q.poll();
      int i = p[0], j = p[1];

      for (int[] d : dir) {
        int newi = i + d[0];
        int newj = j + d[1];

        if (newi < 0 || newj < 0 || newi >= m || newj >= n || heights[newi][newj] < heights[i][j] || vis[newi][newj])
          continue;

        vis[newi][newj] = true;
        q.offer(new int[] { newi, newj });
      }

    }
  }
}