class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]

        if grid[0][0] == 1 or grid[m-1][n-1] == 1:
            return 0
        
        dp[m-1][n-1] = 1

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1 , -1):

                if grid[i][j] == 1:
                    continue
                
                if i+1 < m:
                    dp[i][j] += dp[i+1][j]

                if j+1 < n:
                    dp[i][j] += dp[i][j+1]
        
        return dp[0][0]
