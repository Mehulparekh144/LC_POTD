class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        dp = [[-1] * (amount + 1) for _ in range(n)]

        def dfs(i , target):
            if i == 0:
                if target%coins[i] == 0:
                    return target//coins[i]
                
                return float('inf')
            
            if dp[i][target] != -1:
                return dp[i][target]

            np = dfs(i-1 , target)
            p = float('inf')

            if target >= coins[i]:
                p = 1 + dfs(i , target - coins[i])
            
            dp[i][target] = min(p , np)
            return dp[i][target]
        
        ans = dfs(n-1,amount)
        return -1 if ans == float('inf') else ans
        