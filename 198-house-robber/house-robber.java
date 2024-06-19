class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        dp[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            int p = nums[i] + dp[i+2];
            int np = dp[i+1];
            dp[i] = Math.max(np, p);
        }

        return dp[0];
    }
}