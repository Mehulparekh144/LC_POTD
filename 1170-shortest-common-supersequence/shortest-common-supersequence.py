class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        m = len(s1)
        n = len(s2)

        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]

        for i in range(m-1 , -1 , -1):
            for j in range(n-1 , -1 , -1):
                if s1[i] == s2[j]:
                    dp[i][j] = 1 + dp[i+1][j+1]
                else:
                    dp[i][j] = max(dp[i+1][j] , dp[i][j+1])


        res = ""
        i , j = 0 , 0

        while i < m and j < n:
            if s1[i] == s2[j]:
                res += s1[i]
                i += 1
                j += 1
            elif dp[i+1][j] >= dp[i][j+1]:
                res += s1[i]
                i += 1
            else:
                res += s2[j]
                j += 1
        
        while i < m:
            res += s1[i]
            i += 1
        
        while j < n:
            res += s2[j]
            j += 1
        
        return res
        
        