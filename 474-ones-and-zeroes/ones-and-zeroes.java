class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
      dp = new int[strs.length][m+1][n+1];
      for(int[][] mat : dp){
        for(int[] row : mat){
          Arrays.fill(row ,-1);
        }
      }
      return solve(0, strs , m , n);
    }

    private int solve(int i , String[] strs , int m , int n){
      if(i >= strs.length) return 0;

      if(dp[i][m][n] != -1) return dp[i][m][n];

      int np = solve(i+1 , strs , m , n);

      int p = 0;

      int countZeroes = 0;
      int countOnes = 0;

      for(char c : strs[i].toCharArray()){
        if(c == '0'){
          countZeroes++;
        } else{
          countOnes++;
        }
      }

      if(countZeroes <= m && countOnes <= n){
        p = 1 + solve(i+1 , strs , m - countZeroes , n - countOnes);
      }

      return dp[i][m][n] = Math.max(p , np);
    }
}