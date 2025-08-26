class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        dp = [[0 for _ in range(len(triangle[i]))] for i in range(len(triangle)) ]

        for j in range(len(triangle[-1])):
            dp[-1][j] = triangle[-1][j]

        for i in range(len(triangle) - 2, -1, -1):
            for j in range(i , -1 , -1):
                dp[i][j] = triangle[i][j] + min(dp[i+1][j+1] , dp[i+1][j]) 
        
        return dp[0][0]
        