class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        dp = triangle[-1][:]

        for i in range(len(triangle) - 2, -1, -1):
            for j in range(i+1):
                dp[j] = triangle[i][j] + min(dp[j+1] , dp[j]) 
        
        return dp[0]
        