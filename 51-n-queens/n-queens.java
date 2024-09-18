class Solution {
List<List<String>> res;
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    res = new ArrayList<>();
    for (char[] row : board)
      Arrays.fill(row, '.');

    solve(0, board);
    return res;
  }

  private void solve(int j, char[][] board) {
    if (j == board.length){
      res.add(construct(board));
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (isSafe(i, j, board)) {
        board[i][j] = 'Q';
        solve(j + 1, board);
        board[i][j] = '.';
      }
    }
  }

  private List<String> construct(char[][] board){
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
    int n = board.length;
    int i1 = i;
    int j1 = j;

    // We have to check 8 directions to place a queen but some of them there is no need to check. 
    // Up and down is not needed as only one queen will be placed in a column
    // right top diagonal , right and right bottom diagonal too as no queen as been placed at that column yet
    // SO that's why we check top left diagonal , left and top right diagonal only

    while (i1 >= 0 && j1 >= 0) {
      if (board[i1][j1] == 'Q')
        return false;
      i1--;
      j1--;
    }


    i1 = i;
    j1 = j;

    while (j1 >= 0) {
      if (board[i1][j1] == 'Q') {
        return false;
      }
      j1--;
    }

    i1 = i;
    j1 = j;

    while (i1 < n && j1 >= 0) {
      if (board[i1][j1] == 'Q')
        return false;
      i1++;
      j1--;
    }

    return true;

  }
}