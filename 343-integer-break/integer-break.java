class Solution {
  int[] dp;

  public int integerBreak(int n) {
    if (n < 2)
      return 0;

    dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solve(n);
  }

  private int solve(int n) {
    if(n < 2){
      return 0;
    }

    if(dp[n] != -1) return dp[n];

    int maxProduct = 0;
    for (int i = 1; i < n; i++) {
      int product = Math.max(i * solve(n - i), i * (n - i));
      maxProduct = Math.max(maxProduct, product);
    }
    return dp[n] = maxProduct;
  }
}