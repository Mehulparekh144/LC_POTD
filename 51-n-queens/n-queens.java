class Solution {
  List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
          Arrays.fill(row , '.');
        }

        solve(0 , board);
        return res;

    }

    private void solve(int col , char[][] board){
      if(col == board.length){
        res.add(construct(board));
        return;
      }

      for(int row = 0 ; row < board.length ; row++){
        if(isSafe(row , col , board)){
          board[row][col] = 'Q';
          solve(col + 1 , board);
          board[row][col] = '.';
        }
      }
    }

    private boolean isSafe(int row , int col , char[][] board){
      int row_ = row;
      int col_ = col;

      while(row_ >= 0 && col_ >= 0){
        if(board[row_][col_] == 'Q'){
          return false;
        }
        row_--;
        col_--;
      }

      row_ = row;
      col_ = col;

      while(col_ >= 0){
        if(board[row_][col_] == 'Q'){
          return false;
        }
        col_--;
      }

      row_ = row;
      col_ = col;

      while(row_ < board.length  && col_ >= 0 ){
        if(board[row_][col_] == 'Q'){
          return false;
        }
        row_++;
        col_--;
      }

      return true;
    }


    private List<String> construct(char[][] board){
      List<String> temp = new ArrayList<>();
      for(int i = 0 ; i < board.length ; i++){
        temp.add(String.valueOf(board[i]));
      }
      return temp;
    }
}