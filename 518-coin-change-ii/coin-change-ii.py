class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)

        dp = [[0 for _ in  range(amount+1)] for _ in range(n+1)]

        dp[n][0] = 1

        for i in range(n-1 , -1 , -1):
            for target in range(amount+1):

                np = dp[i+1][target]
                p = 0
                if target >= coins[i]:
                    p = dp[i][target - coins[i]]
                
                dp[i][target] = np + p
        
        return dp[0][amount]


        # def dfs(i , target):

        #     if i >= n:
        #         if target == 0:
        #             return 1
        #         return 0 
            
        #     np = dfs(i+1 , target)
        #     p = 0
        #     if target >= coins[i]:
        #         p = dfs(i , target - coins[i])
            
        #     return np + p
        
        # return dfs(0 , amount)