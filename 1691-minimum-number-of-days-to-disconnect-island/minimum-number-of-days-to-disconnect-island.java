class Solution {
  public int minDays(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int count = 0;
    Set<String> vis = new HashSet<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !vis.contains(i + "," + j)) {
          dfs(i, j, grid, vis);
          count++;
        }
      }
    }

    if (count != 1)
      return 0;

    for (String coord : vis) {
      String[] parts = coord.split(",");
      int r = Integer.parseInt(parts[0]);
      int c = Integer.parseInt(parts[1]);
      grid[r][c] = 0;

      Set<String> vis2 = new HashSet<>();
      count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1 && !vis2.contains(i + "," + j)) {
            dfs(i, j, grid, vis2);
            count++;
          }
        }
      }

      if (count != 1)
        return 1;

      grid[r][c] = 1;
    }

    return 2;
  }

  private void dfs(int i, int j, int[][] grid, Set<String> vis) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis.contains(i + "," + j)) {
      return;
    }

    vis.add(i + "," + j);
    dfs(i + 1, j, grid, vis);
    dfs(i - 1, j, grid, vis);
    dfs(i, j + 1, grid, vis);
    dfs(i, j - 1, grid, vis);
  }
}