class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];

        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >= 0 ; buy--){
                if(buy == 1){
                    dp[i][buy] = Math.max(dp[i+1][1] , dp[i+1][0] - prices[i]);
                } else{
                    dp[i][buy] = Math.max(dp[i+1][0] , dp[i+2][1] + prices[i]);
                }
            }
        }

        return dp[0][1];
    }
}