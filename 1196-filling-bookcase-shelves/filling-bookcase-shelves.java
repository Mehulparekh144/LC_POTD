class Solution {
  public int minHeightShelves(int[][] books, int shelfWidth) {
    int[] dp = new int[books.length+1];
    dp[0] = 0;

    for (int i = 1; i <= books.length; i++) {
      int np = books[i-1][1] + dp[i - 1];
      int p = Integer.MAX_VALUE;
      int width = 0;
      int height = 0;

      for (int j = i; j > 0; j--) {
        width += books[j-1][0];
        if (width > shelfWidth)
          break;

        height = Math.max(height, books[j-1][1]);
        p = Math.min(p, height + dp[j - 1]);
      }

      dp[i] = Math.min(p, np);
    }

    return dp[books.length];
  }

}