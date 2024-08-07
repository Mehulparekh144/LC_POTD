class Solution {
  int[] dp;

  public String stoneGameIII(int[] stoneValue) {
    dp = new int[stoneValue.length + 1];

    for (int i = stoneValue.length - 1; i >= 0; i--) {
      int pickOne = stoneValue[i] - dp[i + 1];
      int pickTwo = Integer.MIN_VALUE;
      int pickThree = Integer.MIN_VALUE;

      if (i + 2 <= stoneValue.length) {
        pickTwo = stoneValue[i] + (i + 1 < stoneValue.length ? stoneValue[i + 1] : 0) - dp[i + 2];
      }

      if (i + 3 <= stoneValue.length) {
        pickThree = stoneValue[i] + (i + 1 < stoneValue.length ? stoneValue[i + 1] : 0)
            + (i + 2 < stoneValue.length ? stoneValue[i + 2] : 0) - dp[i + 3];

      }

      dp[i] = Math.max(pickOne, Math.max(pickTwo, pickThree));
    }

    int res = dp[0];
    if (res > 0) {
      return "Alice";
    } else if (res < 0) {
      return "Bob";
    } else {
      return "Tie";
    }
  }

  // private int solve(int i, int[] stoneValue) {
  // if (i >= stoneValue.length)
  // return 0;
  // if (dp[i] != -1)
  // return dp[i];

  // int pickOne = stoneValue[i] - solve(i + 1, stoneValue);
  // int pickTwo = stoneValue[i] + (i + 1 < stoneValue.length ? stoneValue[i + 1]
  // : 0) - solve(i + 2, stoneValue);
  // int pickThree = stoneValue[i] + (i + 1 < stoneValue.length ? stoneValue[i +
  // 1] : 0)
  // + (i + 2 < stoneValue.length ? stoneValue[i + 2] : 0) - solve(i + 3,
  // stoneValue);

  // return dp[i] = Math.max(pickOne, Math.max(pickTwo, pickThree));
  // }
}