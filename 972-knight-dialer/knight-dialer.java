import java.util.HashMap;
import java.util.Map;

class Solution {
  private static final int MOD = (int) 1e9 + 7;
  private static final int[][] MOVES = {
      { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 },
      { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
  };

  public int knightDialer(int n) {
    if (n == 1)
      return 10;

    int[][][] dp = new int[4][3][n + 1];

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (isValid(i, j)) {
          dp[i][j][1] = 1;
        }
      }
    }

    for (int len = 2; len <= n; len++) {
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 3; j++) {
          if (isValid(i, j)) {
            int count = 0;
            for (int[] move : MOVES) {
              int ni = i + move[0];
              int nj = j + move[1];
              if (isValid(ni, nj)) {
                count = (count + dp[ni][nj][len - 1]) % MOD;
              }
            }
            dp[i][j][len] = count;
          }
        }
      }
    }

    int result = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (isValid(i, j)) {
          result = (result + dp[i][j][n]) % MOD;
        }
      }
    }

    return result;
  }

  private boolean isValid(int i, int j) {
    return (i >= 0 && j >= 0 && i < 4 && j < 3 && (i != 3 || j != 0) && (i != 3 || j != 2));
  }
}
