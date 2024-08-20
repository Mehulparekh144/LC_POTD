class Solution {
  int[][] dp;

  public int stoneGameII(int[] piles) {
    int total = Arrays.stream(piles).sum();
    int n = piles.length;
    dp = new int[n + 1][n + 1];

    for (int i = n - 1; i >= 0; i--) {
      for (int M = n ; M >= 1; M--) {

        int stones = 0;
        dp[i][M] = Integer.MIN_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
          if (i + x > piles.length)
            continue;
          stones += piles[i + x - 1];
          dp[i][M] = Math.max(
              dp[i][M],
              stones - dp[i+x][Math.max(x , M)] );
        }

      }
    }

    return (total + dp[0][1])/2;

    // To get stones alice has
    // Total = A + B
    // solve = A - B
    // 2A/2 = A
    // return (total + solve(0, piles, 1)) / 2;
  }

  // The solve function gives difference of stones between Alice and Bob (A-B)
  // private int solve(int i, int[] piles, int M) {
  //   if (i == piles.length) {
  //     return 0;
  //   }

  //   if (dp[i][M] != -1)
  //     return dp[i][M];

  //   int total = Integer.MIN_VALUE;
  //   int stones = 0;
  //   for (int x = 1; x <= 2 * M; x++) {
  //     if (i + x > piles.length)
  //       continue;
  //     stones += piles[i + x - 1];
  //     total = Math.max(
  //         total,
  //         stones - solve(i + x, piles, Math.max(M, x)));
  //   }

  //   return dp[i][M] = total;
  // }
}