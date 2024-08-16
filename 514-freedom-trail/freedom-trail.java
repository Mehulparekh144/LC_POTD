class Solution {
  int n;
  int[][] dp;
  public int findRotateSteps(String ring, String key) {
    n = ring.length();
    dp = new int[n+1][key.length() + 1];

    for(int[] row : dp) Arrays.fill(row , -1);
    return solve(0, 0, ring, key);
  }

  private int solve(int i, int j, String ring, String key) {
    if (j >= key.length()) {
      return 0;
    }

    if(dp[i][j] != -1) return dp[i][j];

    int steps = Integer.MAX_VALUE;

    for (int k = 0; k < n; k++) {
      if (ring.charAt(k) == key.charAt(j)) {
        int dist = Math.min(Math.abs(i - k), n - Math.abs(i - k));
        steps = Math.min(steps, dist + solve(k, j + 1, ring, key));
      }
    }

    steps++;

    return dp[i][j] = steps;
  }
}