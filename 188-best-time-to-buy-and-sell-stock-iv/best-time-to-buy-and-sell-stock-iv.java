class Solution {
    public int maxProfit(int k, int[] prices) {
           int[][] prev = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int m = 1; m <= k; m++) {
                    if (buy == 1) {
                        curr[buy][m] = Math.max(prev[buy][m], prev[0][m] - prices[i]);
                    } else {
                        curr[buy][m] = Math.max(prev[buy][m], prev[1][m - 1] + prices[i]);
                    }
                }
            }

            prev = curr.clone();
        }

        return prev[1][k];

    }
}