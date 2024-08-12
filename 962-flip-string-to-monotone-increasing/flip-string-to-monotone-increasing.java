class Solution {
  int[][] dp;
  public int minFlipsMonoIncr(String s) {
    dp = new int[s.length()][2];
    for(int[] row : dp){
      Arrays.fill(row , -1);
    }
    return solve(0, s, 0);
  }

  private int solve(int i, String s, int prev) {
    if (i >= s.length()) {
      return 0;
    }

    if(dp[i][prev] != -1) return dp[i][prev];

    int curr = s.charAt(i) - '0';

    int flip = Integer.MAX_VALUE;
    int noflip = Integer.MAX_VALUE;

    if (curr == 0) {
      flip = 1 + solve(i + 1, s, 1);
      if (prev == 0) {
        noflip = solve(i + 1, s, 0);
      }
    } else {
      noflip = solve(i + 1, s, 1);
      if (prev == 0) {
        flip = 1 + solve(i + 1, s, 0);
      }
    }

    return dp[i][prev] = Math.min(flip, noflip);
  }
}