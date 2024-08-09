class Solution {
    public int numMagicSquaresInside(int[][] grid) {

        int count = 0;
        for(int i = 0 ; i <= grid.length - 3 ; i++){
          for(int j = 0 ; j <= grid[0].length - 3 ; j++){
            if(isValid(grid, i , j)){
              count++;
            }
          }
        }

        return count;
    }



  private boolean isValid(int[][] grid , int i1 , int j1 ){

    if(grid[i1+1][j1+1] != 5) return false;

    Set<Integer> s = new HashSet<>();
    for(int k = 0 ; k < 3 ; k++){
      for(int m = 0 ; m < 3 ; m++){
        int val = grid[i1+k][j1+m];
        if(val > 9 || val < 0 || s.contains(val)) return false;
        s.add(grid[i1 + k][j1 + m]);
      }
    }


    int[] sums = new int[8];

    for(int i = 0 ; i < 3 ; i++){
      sums[0] += grid[i1 + i][j1];
      sums[1] += grid[i1 + i][j1 + 1];
      sums[2] += grid[i1 + i][j1 + 2];

      sums[3] += grid[i1][j1 + i];
      sums[4] += grid[i1 + 1][j1 + i];
      sums[5] += grid[i1 + 2][j1 + i];
    }

    sums[6] += grid[i1][j1] + grid[i1+1][j1+1] + grid[i1+2][j1+2];
    sums[7] += grid[i1][j1 + 2] + grid[i1 + 1][j1 + 1] + grid[i1 + 2][j1];

    for(int sum : sums){
      if(sum != 15) return false;
    }

    return true;



  }
}