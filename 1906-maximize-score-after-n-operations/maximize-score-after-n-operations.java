class Solution {
  Map<Integer, Integer> dp;

  public int maxScore(int[] nums) {
    dp = new HashMap<>();
    return dfs(0, 1, nums);
  }

  private int dfs(int mask, int op, int[] nums) {
    if (dp.containsKey(mask))
      return dp.get(mask);

    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {

        if (((1 << i) & mask) != 0 || ((1 << j) & mask) != 0) {
          continue;
        }

        int newMask = (1 << i) | mask | (1 << j);

        int score = op * gcd(nums[i], nums[j]);
        max = Math.max(max, score + dfs(newMask, op + 1, nums));
      }
    }

    dp.put(mask, max);
    return max;
  }

  private int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a%b);
  }
}
