class Solution {
  private boolean solve(int i , int j , char[][] board , String word , int idx){
    int m = board.length;
    int n = board[0].length;
    if(idx == word.length()){
      return true;
    }
    if(i >= m || j >= n || i < 0 || j < 0){
      return false;
    }
    if(board[i][j] != word.charAt(idx)){
      return false;
    }

    char temp = board[i][j];
    board[i][j] = '#';
    boolean up = solve(i-1 , j , board , word , idx + 1);
    boolean down = solve(i+1 , j , board , word , idx + 1);
    boolean left = solve(i , j-1, board , word , idx + 1);
    boolean right = solve(i , j+1 , board, word , idx + 1);
    board[i][j] = temp;
    return up || down || left || right;
  }
    public boolean exist(char[][] board, String word) {
      int m = board.length;
      int n = board[0].length;

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(board[i][j] == word.charAt(0)){
            if(solve(i , j , board , word, 0)){
              return true;
            }
          }
        }
      }

      return false;
    }
}