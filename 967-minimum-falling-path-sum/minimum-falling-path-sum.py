class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        res = float('inf')

        dp = matrix[n-1][:]
        curr = [0] * n
        
        for i in range(n-2 , -1 , -1):
            for j in range(n-1, -1 , -1):
                curr[j] = matrix[i][j] + min(
                    dp[j],
                    dp[j-1] if j-1 >= 0 else float('inf'),
                    dp[j+1] if j+1 < n else float('inf') 
                )
            
            dp = curr[:]


        for j in range(n):
            res = min(res , dp[j])
        
        return res
        