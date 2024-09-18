class Solution {
  List<List<String>> res;
  boolean[] cols;
  boolean[] tld;
  boolean[] bld;

  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    res = new ArrayList<>();
    for (char[] row : board)
      Arrays.fill(row, '.');

    
    cols = new boolean[n];
    tld = new boolean[2*n];
    bld = new boolean[2*n];

    solve(0, board);
    return res;
  }

  private void solve(int j, char[][] board) {
    if (j == board.length) {
      res.add(construct(board));
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (isSafe(i, j, board)) {
        board[i][j] = 'Q';
        // Check the row. There might be confusion here as in why we check cols[i] and not cols[j] because at this stage we are checking for jth column only and since we go from 0th column to jth jth won't be filled before
        cols[i] = true;
        // Top left
        tld[i+j] = true;
        // Top right
        bld[i-j+board.length] = true;

        solve(j + 1, board);
        board[i][j] = '.';
        cols[i] = false;
        tld[i+j] = false;
        bld[i-j+board.length] = false;
      }
    }
  }

  private List<String> construct(char[][] board) {
    List<String> newBoard = new ArrayList<>();

    for (char[] chars : board) {
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < board.length; j++) {
        s.append(chars[j]);
      }
      newBoard.add(s.toString());
    }

    return newBoard;
  }

  private boolean isSafe(int i, int j, char[][] board) {
    return !cols[i] && !tld[i+j] && !bld[i-j + board.length];
  }
}