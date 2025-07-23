class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        dp = [[0] * (amount + 1) for _ in range(n)]

        for j in range(amount+1):
            if j%coins[0] == 0:
                dp[0][j] = j//coins[0]
            else:
                dp[0][j] = float('inf')

        for i in range(1, n):
            for j in range(amount+1):
                np = dp[i-1][j]
                p = float('inf')
                if j >= coins[i]:
                    p = 1 + dp[i][j-coins[i]]  
                
                dp[i][j] = min(p , np)
            
        return -1 if dp[n-1][amount] == float('inf') else dp[n-1][amount]
        