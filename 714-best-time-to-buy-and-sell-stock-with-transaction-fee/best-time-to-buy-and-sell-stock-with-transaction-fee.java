class Solution {
    public int maxProfit(int[] prices, int fee) {
          int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i = prices.length - 1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >= 0 ; buy--){
                if(buy == 1 ){
                    curr[buy] = Math.max(prev[1] , prev[0] - prices[i]);
                } else{
                    curr[buy] = Math.max(prev[0] , prev[1] + prices[i] - fee);
                }
            }

            prev = curr.clone();
        }

        return prev[1];
    }
}