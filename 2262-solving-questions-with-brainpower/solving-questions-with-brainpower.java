class Solution {

  public long mostPoints(int[][] questions) {
    long[] dp = new long[questions.length + 1];


    for (int i = questions.length - 1 ; i >= 0 ; i--) {
      long np = dp[i + 1];
      long p = questions[i][0];
      if (i + questions[i][1] + 1 < questions.length) {
        p += dp[i + questions[i][1] + 1];
      }
      dp[i] = Math.max(np, p);
    }

    return dp[0];
  }

}