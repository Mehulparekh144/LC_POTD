class Solution {
  int[][] dp;
  public int paintWalls(int[] cost, int[] time) {
    dp = new int[cost.length][cost.length + 1];
    for(int[] row  : dp){
      Arrays.fill(row , -1);
    }
    return solve(0, cost, time, cost.length);
  }

  private int solve(int i, int[] cost, int[] time, int remain) {
    if(remain <= 0) return 0;
    if (i == cost.length) {
      return (int) 1e9;
    }

    if(dp[i][remain] != -1) return dp[i][remain];

    int p = cost[i] + solve(i+1 , cost , time , remain - 1 - time[i]);
    int np = solve(i+1 , cost , time , remain);

    return dp[i][remain] = Math.min(p , np);

  }
}