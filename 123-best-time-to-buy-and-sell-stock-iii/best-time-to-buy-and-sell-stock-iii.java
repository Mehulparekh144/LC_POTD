class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2][3];
        for(int[][] grid : dp){
            for(int[] row : grid){
                Arrays.fill(row , -1);
            }
        }
        return solve(0 , prices , 1 , 2);
    }

    private int solve(int i , int[] prices , int buy , int k){
        if(i == prices.length || k == 0) return 0;

        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        if(buy == 1){
            dp[i][buy][k] = Math.max(solve(i+1 , prices , 1 , k) , solve(i+1 , prices , 0 , k) - prices[i]);
        } else{
            dp[i][buy][k] = Math.max(solve(i+1 , prices , 0 , k) , solve(i+1 , prices , 1 , k-1) + prices[i]);
        }

        return dp[i][buy][k];
    }
}