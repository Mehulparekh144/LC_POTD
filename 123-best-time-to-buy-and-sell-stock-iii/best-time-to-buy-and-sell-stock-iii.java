class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];

        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >= 0 ; buy--){
                for(int k = 1 ; k <= 2 ; k++){
                    if(buy == 1){
                        dp[i][buy][k] = Math.max(dp[i+1][buy][k] , dp[i+1][0][k] - prices[i]);
                    } else{
                        dp[i][buy][k] = Math.max(dp[i+1][buy][k] , dp[i+1][1][k-1] + prices[i]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}