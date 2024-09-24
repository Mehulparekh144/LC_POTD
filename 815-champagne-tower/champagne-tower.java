class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];

        dp[0][0] = poured;

        for(int i = 0 ; i <= query_row ; i++){
          for(int j = 0 ; j <= query_row ; j++){

            if(dp[i][j] > 1){
              double excess = (double) (dp[i][j] - 1)/2;
              dp[i][j] = 1;
              dp[i+1][j] += excess;
              dp[i+1][j+1] += excess;
            }
          }
        }

        return dp[query_row][query_glass];
    }
}