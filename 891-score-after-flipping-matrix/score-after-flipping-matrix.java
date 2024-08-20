class Solution {
    public int matrixScore(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      // Most Significant Bit
      int score = m * (1 << (n-1));

      for(int j = 1 ; j < n ; j++){

        // If current cell values matches the 1st column's value then increment number of ones. As we 1st column all values are one.
        int ones = 0;
        for (int[] ints : grid) {
          if(ints[0] == 1){
            ones += ints[j];
          } else{
            ones += 1 - ints[j];
          }
        }

        int zeroes = m - ones;

        score += Math.max(ones , zeroes) * (1 << (n - j - 1));

      }

      return score;


    }
}