class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean col0 = false;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;

          if (i > 0) {
            matrix[i][0] = 0;
          } else {
            col0 = true;
          }
        }
      }
    }

    for(int i = 1 ; i < m ; i++ ){
      for(int j = 1 ; j < n ; j++){

        if(matrix[0][j] == 0 || matrix[i][0] == 0){
          matrix[i][j] = 0;
        }
      }
    }

    if(matrix[0][0] == 0){
      for(int i = 1 ; i < m ; i++){
        matrix[i][0] = 0;
      }
    }

    if(col0){
      for(int j = 0 ; j < n ; j++){
        matrix[0][j] = 0;
      }
    }
  }
}