class Solution {
  long[][] dp;
  public long maxAlternatingSum(int[] nums) {
    dp = new long[nums.length][2];
    for(long[] row : dp ) Arrays.fill(row , -1);
    return solve(0, 1, nums);
  }

  private long solve(int i, int isPos, int[] nums) {
    if (i >= nums.length)
      return 0;

    if(dp[i][isPos] != -1) return dp[i][isPos];
    long np = solve(i + 1, isPos, nums);

    long p = 0;
    if (isPos == 1) {
      p = nums[i] + solve(i + 1, 0, nums);
    } else {
      p = -nums[i] + solve(i + 1, 1, nums);
    }

    return dp[i][isPos] = Math.max(p, np);
  }
}