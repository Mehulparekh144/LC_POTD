class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [0]*n

        prev1 = cost[n-1]
        prev2 = cost[n-2]

        for i in range(n-3 , -1 , -1):
            curr = cost[i] + min(prev2 , prev1)
            prev1 = prev2
            prev2 = curr
        
        return min(prev1 , prev2)

        # def dfs(i):
        #     if i >= n:
        #         return 0

        #     if dp[i] != -1:
        #         return dp[i]

        #     dp[i] = cost[i] + min(dfs(i+1) , dfs(i+2))
        #     return dp[i]

        # return min(dfs(0) , dfs(1))  
        