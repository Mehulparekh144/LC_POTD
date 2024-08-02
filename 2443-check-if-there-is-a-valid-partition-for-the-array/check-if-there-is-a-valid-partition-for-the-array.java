class Solution {
  int[] dp;

  public boolean validPartition(int[] nums) {
    boolean[] dp = new boolean[nums.length + 1];

    dp[nums.length] = true;
    for(int i = nums.length - 1 ; i >= 0 ; i--){
      boolean res = false;
    if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
      res = dp[i+2];
    }

    if (i + 2 < nums.length) {
      if ((nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) || (nums[i] + 1 == nums[i + 1] && nums[i + 1] == nums[i + 2] - 1)) {
        res = res || dp[i+3];
      }
    }

    dp[i] = res;

    }

    return dp[0];
  }

  // private boolean dfs(int i, int[] nums) {
  //   if (i == nums.length)
  //     return true;

  //   if (dp[i] != -1)
  //     return dp[i] == 1;

  //   boolean res = false;
  //   if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
  //     res = dfs(i + 2, nums);
  //   }

  //   if (i + 2 < nums.length) {
  //     if ((nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
  //         || (nums[i] + 1 == nums[i + 1] && nums[i + 1] == nums[i + 2] - 1)) {
  //       res = res || dfs(i + 3, nums);
  //     }
  //   }

  //   dp[i] = res ? 1 : 0;
  //   return res;
  // }
}