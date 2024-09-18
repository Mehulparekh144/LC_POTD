class Solution {
  int count;
  boolean[] cols;
  boolean[] tld;
  boolean[] bld;

  public int totalNQueens(int n) {
    count = 0;
    char[][] board = new char[n][n];
    for (char[] row : board)
      Arrays.fill(row, '.');

    cols = new boolean[n];
    tld = new boolean[2 * n];
    bld = new boolean[2 * n];

    solve(0, board);
    return count;
  }

  private void solve(int j, char[][] board) {
    if (j == board.length) {
      count++;
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (isSafe(i, j, board)) {
        board[i][j] = 'Q';
        // Check the row. There might be confusion here as in why we check cols[i] and
        // not cols[j] because at this stage we are checking for jth column only and
        // since we go from 0th column to jth jth won't be filled before
        cols[i] = true;
        // Top left
        tld[i + j] = true;
        // Top right
        bld[i - j + board.length] = true;

        solve(j + 1, board);
        board[i][j] = '.';
        cols[i] = false;
        tld[i + j] = false;
        bld[i - j + board.length] = false;
      }
    }
  }

  private boolean isSafe(int i, int j, char[][] board) {
    return !cols[i] && !tld[i + j] && !bld[i - j + board.length];
  }
}