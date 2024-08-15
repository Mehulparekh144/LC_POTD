class Solution {
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
      int n = jobDifficulty.length;
      if(n < d){
        return -1;
      }   

      dp = new int[n][d + 1];
      for(int[] arr : dp){
        Arrays.fill(arr , -1);
      }

      return solve(0 , jobDifficulty , d);
    }

    private int solve(int i , int[] jobDifficulty , int d){
      if(i == jobDifficulty.length){
        if(d != 0) return (int) 1e9;
        return 0;
      }

      if(d == 0) return (int) 1e9;

      if(dp[i][d] != -1) return dp[i][d];

      int curr = 0;
      int res = (int) 1e9;

      for(int j = i ; j < jobDifficulty.length ; j++){
        curr = Math.max(curr , jobDifficulty[j]);
        res = Math.min(res , curr + solve(j+1 , jobDifficulty , d-1));
      }

      return dp[i][d] = res;
      

    }
}