class Solution {
    int[][]dp;
    private int solve(int i , int[] nums , int prev){
        if(i == nums.length){
            return 0;
        }

        if(dp[i][prev + 1] != -1){
            return dp[i][prev+1];
        }

        int p = 0;
        if(prev == -1 || nums[i] > nums[prev]){
            p = 1 + solve(i+1 , nums , i);
        }
        int np = solve(i+1 , nums , prev);
        return dp[i][prev + 1] =  Math.max(p , np);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(0 , nums  , -1 );
    }
}