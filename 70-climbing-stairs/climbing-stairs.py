class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [-1]*(n+1)

        def dfs(step):
            if step == 0:
                return 1
            if step < 0:
                return 0
            
            if dp[step] != -1:
                return dp[step]
                    
            dp[step] = dfs(step-1) + dfs(step-2)
            return dp[step]
        
        return dfs(n)
        
        