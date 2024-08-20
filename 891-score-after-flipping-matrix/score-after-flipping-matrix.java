class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0 ; i < m ; i++){
          if(grid[i][0] == 0){
            for(int j = 0 ; j < n ; j++){
              grid[i][j] = 1 - grid[i][j];
            }
          }
        }

        for(int j = 1 ; j < n ; j++){
          int countZeroes = 0;

          for(int i = 0 ; i < m ; i++){
            if(grid[i][j] == 0) countZeroes++;
          }

          int countOnes = m - countZeroes;
          if(countZeroes > countOnes){
            for(int i = 0 ; i < m ; i++){
              grid[i][j] = 1 - grid[i][j];
            }
          }
        }

        int sum = 0;

        for(int i = 0 ; i < m ; i++){
          for(int j = 0 ; j < n ; j++){
            sum += grid[i][j] * Math.pow(2 , n - j - 1);
          }
        }

        return sum;

  


    }
}