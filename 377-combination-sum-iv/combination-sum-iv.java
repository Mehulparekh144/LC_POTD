class Solution {
  int[] dp;
    public int combinationSum4(int[] nums, int target) {
      dp = new int[target + 1];
      Arrays.fill(dp , -1);
        return solve(nums , target);
    }

    private int solve(int[] nums , int target){
      if(target == 0) return 1;
      if(dp[target] != -1) return dp[target];
      int res = 0;
      for(int num : nums){
        if(target >= num){
          res += solve(nums , target - num);
        }
      }

      return dp[target] = res;
    }
}