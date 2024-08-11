class Solution {  private static final int MOD = (int) 1e9 + 7;

  public int countVowelPermutation(int n) {
    int[][] dp = new int[n + 1][5];
    int a = 0;
    int e = 1;
    int i = 2;
    int o = 3;
    int u = 4;

    for (int j = 0; j < 5; j++) {
      dp[1][j] = 1;
    }


    for (int j = 2; j <= n; j++) {
      dp[j][a] = (int)(((long)dp[j - 1][e] + dp[j - 1][i] + dp[j - 1][u]) % MOD);
      dp[j][e] = (int)(((long)dp[j - 1][i] + dp[j - 1][a]) % MOD);
      dp[j][i] = (int)(((long)dp[j - 1][o] + dp[j - 1][e]) % MOD);
      dp[j][o] = dp[j - 1][i] % MOD;
      dp[j][u] = (int)(((long)dp[j - 1][i] + dp[j - 1][o]) % MOD);
    }


    int sum = 0;
    for (int j = 0; j < 5; j++) {
      sum = (int)(((long)sum + dp[n][j]) % MOD);
    }

    return sum;
  }
}