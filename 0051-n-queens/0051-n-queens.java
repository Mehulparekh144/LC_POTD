class Solution {
  private List<List<String>> res;

  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    res = new ArrayList<>();
    solve(0, board);
    return res;
  }

  private void solve(int col, char[][] board) {
    if (col == board.length) {
      res.add(construct(board));
      return;
    }

    for (int row = 0; row < board.length; row++) {
      if (isSafe(row, col, board)) {
        board[row][col] = 'Q';
        solve(col + 1, board);
        board[row][col] = '.';
      }
    }
  }

  private boolean isSafe(int row , int col , char[][] board){
    int row_ = row;
    int col_ = col;

    //Checking the top-left diagonal
    while(row_ >= 0 && col_ >= 0){
      if(board[row_][col_] == 'Q'){
        return false;
      }
      row_--;
      col_--;
    }

    row_ = row;
    col_ = col;
    //Checking the columns 
    while(col_ >= 0){
      if(board[row_][col_] == 'Q'){
        return false;
      }
      col_--;
    }

    //Checking the bottom-left diagonal
    row_ = row;
    col_ = col;

    while(row_ < board.length && col_ >= 0){
      if(board[row_][col_] == 'Q'){
        return false;
      }
      row_++;
      col_--;
    }

    return true;
  }

  private List<String> construct(char[][] board){
    List<String> res2 = new ArrayList<>();

    for(int i = 0 ; i < board.length ; i++){
      String string = new String(board[i]);
      res2.add(string);
    }

    return res2;
  }
}