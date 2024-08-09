class Solution {
  int[][] dp;

  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
    }

    int target = (int) Math.ceil(sum / 2);
    dp = new int[stones.length][target + 1];
    for (int[] row : dp)
      Arrays.fill(row, -1);
    return dfs(0, stones, 0, sum, target);
  }

  private int dfs(int i, int[] stones, int total, int sum, int target) {
    if (total >= target || i == stones.length) {
      return Math.abs(total - (sum - total));
    }

    if (dp[i][total] != -1)
      return dp[i][total];

    int np = dfs(i + 1, stones, total, sum, target);
    int p = dfs(i + 1, stones, total + stones[i], sum, target);

    return dp[i][total] = Math.min(np, p);
  }

}