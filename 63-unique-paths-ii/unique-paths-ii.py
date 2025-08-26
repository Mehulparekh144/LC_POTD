class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = {}

        def solve(i,j):
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] != 0:
                return 0
            
            if i == m-1 and j == n-1:
                return 1

            if (i,j) in dp:
                return dp[(i,j)]
            
            dp[(i,j)] = solve(i+1, j) + solve(i, j+1)
            return dp[(i,j)]
        
        return solve(0, 0)
        