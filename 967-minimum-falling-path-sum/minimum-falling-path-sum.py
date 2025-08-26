class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        res = float('inf')

        dp = [[0 for _ in range(n)] for _ in range(n)]

        for j in range(n):
            dp[n-1][j] = matrix[n-1][j]
        
        for i in range(n-2 , -1 , -1):
            for j in range(n-1, -1 , -1):
                dp[i][j] = matrix[i][j] + min(
                    dp[i+1][j],
                    dp[i+1][j-1] if j-1 >= 0 else float('inf'),
                    dp[i+1][j+1] if j+1 < n else float('inf') 
                )


        for j in range(n):
            res = min(res , dp[0][j])
        
        return res
        