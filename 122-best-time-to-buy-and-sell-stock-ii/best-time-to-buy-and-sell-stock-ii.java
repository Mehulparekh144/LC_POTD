class Solution {
  int[][] dp;
  public int maxProfit(int[] prices) {
    dp = new int[prices.length][2];
    for(int[] row : dp) Arrays.fill(row , -1);
    return solve(0, prices, 1);
  }

  private int solve(int i, int[] prices, int buy) {
    if (i == prices.length)
      return 0;
    
    if(dp[i][buy] != -1) return dp[i][buy];

    int cost = 0;
    if (buy == 1) {
      cost = Math.max(
          solve(i + 1, prices, 1),
          solve(i + 1, prices, 0) - prices[i]);
    } else {
      cost = Math.max(
        solve(i+1 , prices , 0),
        solve(i+1 , prices , 1) + prices[i]
      );
    }

    return dp[i][buy] = cost;
  }
}