class Solution {
    public int maxProfit(int[] prices) {
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >= 0 ; buy--){
                for(int k = 1 ; k <= 2 ; k++){
                    if(buy == 1){
                        curr[buy][k] = Math.max(prev[buy][k] , prev[0][k] - prices[i]);
                    } else{
                        curr[buy][k] = Math.max(prev[buy][k] , prev[1][k-1] + prices[i]);
                    }
                }
            }

            prev = curr.clone();
        }

        return prev[1][2];
    }
}