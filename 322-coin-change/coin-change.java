class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for(int j = 1 ; j <= amount ; j++){
            if(j%coins[0] == 0){
                dp[0][j] = j/coins[0];
            } else{
                dp[0][j] = (int) Math.pow(10 , 9);
            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= amount ; j++){
                int np = dp[i-1][j];
                int p = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    p = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(np , p);
            }
        }

        int ans = dp[n-1][amount];
        if(ans == (int) Math.pow(10 , 9)){
            return -1;
        }

        return ans;
    }

}