class Solution {
  public int paintWalls(int[] cost, int[] time) {
    int[][] dp = new int[cost.length + 1][cost.length + 1];

    for (int i = 1; i <= cost.length; i++) {
      dp[cost.length][i] = (int) 1e9;
    }

    for (int i = cost.length - 1; i >= 0; i--) {
      for (int remain = 0; remain <= cost.length; remain++) {

        dp[i][remain] = Math.min(
            dp[i + 1][Math.max(0, remain - time[i] - 1)] +  cost[i],
            dp[i + 1][remain]);

      }
    }
    return dp[0][cost.length];
  }

}