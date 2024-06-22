class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row , -1);
        int ans = solve(n-1 , coins , amount);
        if(ans == (int) Math.pow(10 , 9)){
            return -1;
        }

        return ans;
    }

    private int solve(int i , int[] coins , int amount){
        if(i == 0){
            if(amount%coins[i] == 0){
                return amount/coins[i];
            }
            return (int) Math.pow(10 , 9);
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int np = solve(i-1 , coins , amount);
        int p = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            p = 1 + solve(i , coins , amount - coins[i]);
        }

        return dp[i][amount]= Math.min(p , np);
    }
}