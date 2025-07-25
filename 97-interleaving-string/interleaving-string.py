class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m = len(s1)
        n = len(s2)
        l = len(s3)

        if m + n != l:
            return False

        @cache
        def dfs(i , j , k):
            if i == m and j == n and k == l:
                return True
            
            if k >= l:
                return False
            
            if i < m and s1[i] == s3[k]:
                if dfs(i+1 , j , k+1):
                    return True
            
            if j < n and s2[j] == s3[k]:
                if dfs(i , j+1 , k+1):
                    return True
            
            return False
        
        return dfs(0 , 0 , 0)