class Solution {
  int m;
  int n;

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    m = grid1.length;
    n = grid1[0].length;

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((grid2[i][j] == 1) && dfs(i, j, grid1, grid2)) {
          count++;
        }
      }
    }

    return count;
  }

  private boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {
    if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] != 1)
      return true;

    grid2[i][j] = 0; // Mark the cell as visited
    boolean res = grid1[i][j] == 1;

    res = dfs(i + 1, j, grid1, grid2) && res;
    res = dfs(i - 1, j, grid1, grid2) && res;
    res = dfs(i, j + 1, grid1, grid2) && res;
    res = dfs(i, j - 1, grid1, grid2) && res;

    return res;
  }

}