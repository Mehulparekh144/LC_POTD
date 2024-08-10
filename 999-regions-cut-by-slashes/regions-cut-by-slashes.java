class Solution {
  public int regionsBySlashes(String[] grid) {
    int[][] mat = new int[grid.length * 3][grid.length * 3];

    for (int i = 0 ; i < grid.length ; i++) {
      for(int j = 0 ; j < grid[i].length() ; j++){

        int start = i * 3;
        int end = j * 3;

        if(grid[i].charAt(j) == '/'){
          mat[start][end + 2] = 1;
          mat[start + 1][end + 1] = 1;
          mat[start + 2][end] = 1;
        }

        else if(grid[i].charAt(j) == '\\'){
          mat[start][end] = 1;
          mat[start + 1][end + 1] = 1;
          mat[start + 2][end + 2] = 1;

        }
      }
    }

    int count = 0;

    for(int i = 0 ; i < mat.length ; i++){
      for(int j = 0 ; j < mat.length ; j++){
        if(mat[i][j] == 0){
          dfs(i , j , mat);
          count++;
        }
      }
    }
    
    return count;
  }

  private void dfs(int i , int j , int[][] mat){
    if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 1){
      return;
    }

    mat[i][j] = 1;

    dfs(i+1 , j , mat);
    dfs(i-1 , j , mat);
    dfs(i , j-1 , mat);
    dfs(i , j+1 , mat);
  }
}