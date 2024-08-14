class Solution {

  public int minCost(int n, int[] cuts) {
    List<Integer> list = new ArrayList<>();

    int[][] dp = new int[cuts.length + 2][cuts.length + 2];

    for (int cut : cuts) {
      list.add(cut);
    }
    Collections.sort(list);
    list.addFirst(0);
    list.addLast(n);

    for (int i = cuts.length ; i >= 1; i--) {
      for (int j = 1; j <= cuts.length; j++) {
        if (i > j)
          continue;

        int cost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
          int cut = list.get(j + 1) - list.get(i - 1) + dp[i][k-1] + dp[k + 1][j];
          cost = Math.min(cut, cost);
        }

        dp[i][j] = cost;
      }
    }

    return dp[1][cuts.length];

  }

}