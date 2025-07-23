class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [0]*n

        dp[n-1] = cost[n-1]
        dp[n-2] = cost[n-2]

        for i in range(n-3 , -1 , -1):
            dp[i] = cost[i] + min(dp[i+1] , dp[i+2])
        
        return min(dp[0] , dp[1])

        # def dfs(i):
        #     if i >= n:
        #         return 0

        #     if dp[i] != -1:
        #         return dp[i]

        #     dp[i] = cost[i] + min(dfs(i+1) , dfs(i+2))
        #     return dp[i]

        # return min(dfs(0) , dfs(1))  
        