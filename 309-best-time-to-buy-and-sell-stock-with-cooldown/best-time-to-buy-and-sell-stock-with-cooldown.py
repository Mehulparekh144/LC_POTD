class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0,0] for _ in range(n+2)]

        for i in range(n-1 , -1 , -1):
            for canBuy in range(2):
                if canBuy == 1:
                    dp[i][canBuy] = max(
                        dp[i+1][0] - prices[i],
                        dp[i+1][1]
                    )
                else:
                    dp[i][canBuy] = max(
                        dp[i+2][1] + prices[i],
                        dp[i+1][0] 
                    )
        
        return dp[0][1]