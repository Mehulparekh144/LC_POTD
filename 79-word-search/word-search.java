class Solution {
    public boolean exist(char[][] board, String word) {
      int m = board.length;
      int n = board[0].length;

      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(board[i][j] == word.charAt(0)){
            if(solve(i , j , word , 0 , board)){
              return true;
            }
          }
        }
      }

      return false;
    }

    private boolean solve(int i , int j , String word , int idx , char[][] board){
      if(idx == word.length()){
        return true;
      }

      if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)){
        return false;
      }

      char temp = board[i][j];
      board[i][j] = '#';

      boolean up = solve(i-1 , j , word , idx + 1 , board);
      boolean down = solve(i+1 , j , word , idx + 1 , board);
      boolean left = solve(i , j-1 , word , idx + 1 , board);
      boolean right = solve(i , j+1 , word , idx + 1 , board);
      
      board[i][j] = temp;

      return up || down || left || right;
    }
}