class Solution {
  public long maxAlternatingSum(int[] nums) {
    long[][] dp = new long[nums.length + 1][2];

    for(int i = nums.length - 1 ; i >= 0 ; i--){
      for(int isPos = 1 ; isPos >= 0 ; isPos--){
        long np = dp[i+1][isPos];

        long p = 0;
        if(isPos == 1){
          p = nums[i] + dp[i+1][0];
        } else{
          p = -nums[i] + dp[i+1][1];
        }

        dp[i][isPos] = Math.max(p , np);
      }
    }

    return dp[0][1];
  }

}