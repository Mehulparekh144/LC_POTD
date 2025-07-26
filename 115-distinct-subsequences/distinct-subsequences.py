class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        dp = [[-1 for _ in range(n+1)] for _ in range(m+1)]

        if m < n:
            return 0
        
        def dfs(i , j):
            if j == n:
                return 1
            
            if i == m:
                return 0

            if dp[i][j] != -1:
                return dp[i][j]
            
            if(s[i] == t[j]):
                dp[i][j] = dfs(i+1, j+1)  + dfs(i+1 , j)
            else:
                dp[i][j] = dfs(i+1,j)
            
            return dp[i][j]
        
        return dfs(0 , 0)

    