class Solution {
  public int minFlipsMonoIncr(String s) {
    int[][] dp = new int[s.length() + 1][2];

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int prev = 0; prev <= 1; prev++) {
        int curr = s.charAt(i) - '0';
        int flip = Integer.MAX_VALUE;
        int noflip = Integer.MAX_VALUE;

        if (curr == 0) {
          flip = 1 + dp[i+1][1];
          if (prev == 0) {
            noflip = dp[i+1][0];
          }
        } else {
          noflip = dp[i+1][1];
          if (prev == 0) {
            flip = 1 + dp[i+1][0];
          }
        }

        dp[i][prev] = Math.min(flip, noflip);
      }
    }

    return dp[0][0];
  }

  // private int solve(int i, String s, int prev) {
  //   if (i >= s.length()) {
  //     return 0;
  //   }

  //   if (dp[i][prev] != -1)
  //     return dp[i][prev];

  //   int curr = s.charAt(i) - '0';

  //   int flip = Integer.MAX_VALUE;
  //   int noflip = Integer.MAX_VALUE;

  //   if (curr == 0) {
  //     flip = 1 + solve(i + 1, s, 1);
  //     if (prev == 0) {
  //       noflip = solve(i + 1, s, 0);
  //     }
  //   } else {
  //     noflip = solve(i + 1, s, 1);
  //     if (prev == 0) {
  //       flip = 1 + solve(i + 1, s, 0);
  //     }
  //   }

  //   return dp[i][prev] = Math.min(flip, noflip);
  // }
}