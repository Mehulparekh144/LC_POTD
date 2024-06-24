class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       dp = new int[n][n+1];
       for(int[] row : dp) Arrays.fill(row , -1);
       return solve(n-1 , nums , -1); 
    }

    private int solve(int i , int[] nums , int prev){
        if(i == 0){
            if(prev == -1 || nums[i] < nums[prev]){
                return 1;
            }

            return 0;
        }

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int np = solve(i-1 , nums , prev);
        int p = 0;
        if(prev == -1 || nums[i] < nums[prev]){
            p = 1 + solve(i-1 , nums , i);
        }

        return dp[i][prev+1] = Math.max(p , np);
    }
}