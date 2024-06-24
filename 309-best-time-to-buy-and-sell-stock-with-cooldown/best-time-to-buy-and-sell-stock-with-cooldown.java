class Solution {
    public int maxProfit(int[] prices) {
        int[] prev2 = new int[2];
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >= 0 ; buy--){
                if(buy == 1){
                    curr[buy] = Math.max(prev[1] , prev[0] - prices[i]);
                } else{
                    curr[buy] = Math.max(prev[0] , prev2[1] + prices[i]);
                }
            }

            prev2 = prev.clone();
            prev = curr.clone();
        }

        return prev[1];
    }
}