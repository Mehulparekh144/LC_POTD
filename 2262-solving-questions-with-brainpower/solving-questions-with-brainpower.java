class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
      dp = new long[questions.length + 1];
      Arrays.fill(dp , -1);
      return solve(0 , questions);   
    }

    private long solve(int i , int[][] questions){
      if(i >= questions.length) return 0;

      if(dp[i] != -1) return dp[i];

      long np = solve(i+1 , questions);
      long p = questions[i][0] + solve(i + questions[i][1] + 1 , questions);
      return dp[i] = Math.max(p , np);
    }
}