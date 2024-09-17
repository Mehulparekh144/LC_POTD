class Solution {
    long[][] dp;
    public long maxScore(int[] a, int[] b) {
      dp = new long[5][b.length + 1];
      for(long[] row : dp) Arrays.fill(row , -1);
      return solve(0 , 0 , a , b);
    }

    private long solve(int i , int j , int[] a , int[] b){
      if(i >= a.length) return 0;
      if(j >= b.length) return (long) -1e12;

      if(dp[i][j] != -1) return dp[i][j];

      long take = (long) a[i]*b[j] + solve(i+1 , j+1 , a , b);
      long notTake = solve(i , j+1 , a , b);

      return dp[i][j] = Math.max(take , notTake);


    }
}