class Solution {
  int[][] dp;

  public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    dp = new int[piles.size() + 1][k + 1];

    for (int i = piles.size() - 1; i >= 0; i--) {
      for (int k1 = 1; k1 <= k; k1++) {

        int np = dp[i + 1][k1];
        int p = 0;
        int total = 0;
        List<Integer> pile = piles.get(i);

        for (int j = 1; j <= Math.min(k1, pile.size()); j++) {
          total += pile.get(j - 1);
          p = Math.max(p, total + dp[i+1][k1-j]);
        }

        dp[i][k1] = Math.max(p, np);

      }

    }

    return dp[0][k];
  }

}