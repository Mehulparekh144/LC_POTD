class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)

        @cache
        def dfs(i , canBuy):
            if i >= n:
                return 0
            
            if canBuy:
                buy = dfs(i+1 , False) - prices[i]
                notBuy = dfs(i+1 , True)
                return max(buy , notBuy)
            else:
                sell = dfs(i+2 , True) + prices[i]
                notSell = dfs(i+1, False)
                return max(sell , notSell)

        return dfs(0 , True) 
