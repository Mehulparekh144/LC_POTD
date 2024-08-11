class Solution {

  public int maxCoins(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int num : nums)
      list.add(num);
    list.addFirst(1);
    list.addLast(1);

    int[][] dp = new int[list.size()][list.size()];

    for (int i = nums.length; i >= 1; i--) {
      for (int j = 1; j <= nums.length; j++) {
        if (i > j)
          continue;
        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
          int coins = list.get(i - 1) * list.get(k) * list.get(j + 1) + dp[i][k-1] + dp[k+1][j];
          max = Math.max(max, coins);
        }

        dp[i][j] = max;

      }
    }

    return dp[1][nums.length];
  }

}